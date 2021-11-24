package com.ihsmarkit.csvtodb.service;

import java.util.List;
import java.util.Optional;

import com.ihsmarkit.csvtodb.dto.FinancialInstrumentDTO;
import com.ihsmarkit.csvtodb.entity.FinancialInstrument;

public interface FinancialInstrumentService {

     void saveInstrumentDetails(final List<FinancialInstrumentDTO> financialInstrumentDTOS) ;

     Optional<FinancialInstrument> findInstrumentById(String id);
}
