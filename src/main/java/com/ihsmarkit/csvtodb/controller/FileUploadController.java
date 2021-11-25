package com.ihsmarkit.csvtodb.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.ihsmarkit.csvtodb.dto.FinancialInstrumentDTO;
import com.ihsmarkit.csvtodb.entity.FinancialInstrument;
import com.ihsmarkit.csvtodb.exception.InvalidRequestException;
import com.ihsmarkit.csvtodb.repository.FinancialInstrumentRepository;
import com.ihsmarkit.csvtodb.utils.CsvReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ihsmarkit.csvtodb.service.FinancialInstrumentService;

import io.swagger.annotations.Api;

@Controller
@Api(tags = "CRUD operations on Financial Instrument entity")
@RequestMapping("/v1")
public class FileUploadController {

    @Autowired
    private FinancialInstrumentService financialInstrumentService;

    @Autowired
    FinancialInstrumentRepository repository;

    private static final Logger LOG = Logger.getLogger(FileUploadController.class);

    @PostMapping("/instruments")
    public synchronized void processFileUpload(@RequestParam("file") final MultipartFile file) {

        if(!isFileValid(file)){
            throw new InvalidRequestException("Provided CSV file is invalid.");
        }
        try {
            final byte[] fileAsBytes = file.getBytes();
            final CsvReader csvReader = new CsvReader(fileAsBytes);
            final List<FinancialInstrumentDTO> instruments = csvReader.getInstruments();
            financialInstrumentService.saveInstrumentDetails(instruments);

        } catch (final IOException exception) {
            LOG.error(exception.getMessage(),exception);
        }
    }

    @GetMapping("/instruments/{id}")
    public synchronized ResponseEntity<FinancialInstrument> getPriceById(@PathVariable("id") String id) {

        Optional<FinancialInstrument> instrumentData = financialInstrumentService.findInstrumentById(id);
        if (instrumentData.isPresent()) {
            return new ResponseEntity<>(instrumentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private boolean isFileValid(final MultipartFile file) {
        if (file.isEmpty()) {
            return false;
        }

        final String allowedFileExtension = ".csv"; //Assuming that the producers upload records from a csv file
        final String fileName = file.getOriginalFilename();
        final int index = fileName.lastIndexOf('.');
        final String fileExtension = fileName.substring(index, fileName.length());

        return allowedFileExtension.equalsIgnoreCase(fileExtension);
    }
}
