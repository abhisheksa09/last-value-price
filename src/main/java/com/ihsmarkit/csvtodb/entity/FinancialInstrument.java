package com.ihsmarkit.csvtodb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "FINANCIAL_INSTRUMENT")
public class FinancialInstrument {

    /**
     * Field to indicate the instrument this price refers to
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * Field to indicate when the price was determined.
     */
    @Column(name = "AS_OF", nullable= false)
    private Date asOf;

    /**
     * Financial Instrument price data.
     */
    @Column(name = "PRICE_DATA", nullable= false)
    private String payLoad;

    public String getId() {
        return id;
    }

    public Date getAsOf() {
        return asOf;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAsOf(Date asOf) {
        this.asOf = asOf;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }
}
