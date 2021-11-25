package com.ihsmarkit.csvtodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ihsmarkit.csvtodb.dto.FinancialInstrumentDTO;
import com.ihsmarkit.csvtodb.entity.FinancialInstrument;
import com.ihsmarkit.csvtodb.exception.InvalidRequestException;
import com.ihsmarkit.csvtodb.repository.FinancialInstrumentRepository;

@Service
public class FinancialInstrumentServiceImpl implements FinancialInstrumentService {

    @Autowired
    private FinancialInstrumentRepository financialInstrumentRepository;

    /**
     * Saves the financial instrument details specified to the database.
     *
     * @param financialInstrumentDTOS the financial instruments to be saved
     */
    @Override
    public void saveInstrumentDetails(final List<FinancialInstrumentDTO> financialInstrumentDTOS) {
        if(financialInstrumentDTOS.isEmpty()){
            throw new InvalidRequestException("Price details are empty. Cannot save");
        }

        for(final FinancialInstrumentDTO financialInstrumentDTO : financialInstrumentDTOS) {
            financialInstrumentRepository.save(dtoToEntity(financialInstrumentDTO));
        }
    }

    @Override
    public Optional<FinancialInstrument> findInstrumentById(String id) {
        return financialInstrumentRepository.findById(id);
    }

    /**
     * Converts DTO to entity object.
     *
     * @param financialInstrumentDTO the DTO to be converted
     * @return the converted entity object
     */
    private FinancialInstrument dtoToEntity(final FinancialInstrumentDTO financialInstrumentDTO) {

        if(isFinancialInstrumentInfoInValid(financialInstrumentDTO)) {
            throw new InvalidRequestException("Required fields in the CSV are empty. Cannot save");
        }
        final FinancialInstrument financialInstrument = new FinancialInstrument();
        financialInstrument.setId(financialInstrumentDTO.getId());
        financialInstrument.setAsOf(financialInstrumentDTO.getAsOf());
        financialInstrument.setPayLoad(financialInstrumentDTO.getPayLoad());

        return financialInstrument;
    }

    /**
     * Validates the specified instrument details to see if it is invalid.
     *
     * @param financialInstrumentDTO
     * @return true if the specified details are valid, false otherwise
     */
    private boolean isFinancialInstrumentInfoInValid(final FinancialInstrumentDTO financialInstrumentDTO) {
                return financialInstrumentDTO == null ||
                financialInstrumentDTO.getId() == null ||
                financialInstrumentDTO.getId().isEmpty() ||
                financialInstrumentDTO.getAsOf() == null ||
                financialInstrumentDTO.getPayLoad() == null ||
                financialInstrumentDTO.getPayLoad().isEmpty();
    }
}
