package com.ihsmarkit.csvtodb.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "Financial Instrument")
@Data
public class FinancialInstrumentDTO {

    /**
     * Field to indicate the instrument this price refers to
     */
    private String id;

    /**
     * Field to indicate when the price was determined.
     */
    private Date asOf;

    /**
     * Financial Instrument price data.
     */
    private String payLoad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAsOf() {
        return asOf;
    }

    public void setAsOf(Date asOf) {
        this.asOf = asOf;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }
}
