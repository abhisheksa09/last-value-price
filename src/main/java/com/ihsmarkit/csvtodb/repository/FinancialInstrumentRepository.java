package com.ihsmarkit.csvtodb.repository;

import com.ihsmarkit.csvtodb.entity.FinancialInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialInstrumentRepository extends JpaRepository<FinancialInstrument, String> {

}
