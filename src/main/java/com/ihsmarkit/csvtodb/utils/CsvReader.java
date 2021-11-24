package com.ihsmarkit.csvtodb.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.ihsmarkit.csvtodb.dto.FinancialInstrumentDTO;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class to read CSV file with instruments data.
 */
public class CsvReader {

    private byte[] fileAsBytes;

    public CsvReader(byte[] fileAsBytes) {

        super();
        this.fileAsBytes = fileAsBytes;
    }

    public List<FinancialInstrumentDTO> getInstruments() throws IOException {

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.typedSchemaFor(FinancialInstrumentDTO.class).withHeader();
        MappingIterator<FinancialInstrumentDTO> pricesIter = csvMapper.readerFor(FinancialInstrumentDTO.class).with(csvSchema.withColumnSeparator(CsvSchema.DEFAULT_COLUMN_SEPARATOR))
                .readValues(fileAsBytes);

        List<FinancialInstrumentDTO> listOfPrices = pricesIter.readAll().stream().collect(Collectors.toList());

        return listOfPrices;
    }
}
