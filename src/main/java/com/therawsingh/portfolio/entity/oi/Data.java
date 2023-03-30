package com.therawsingh.portfolio.entity.oi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private String strikePrice;
    private String expiryDate;
    private CE CE;
    private PE PE;

    public Data() {
    }

    public Data(String strikePrice, String expiryDate, com.therawsingh.portfolio.entity.oi.CE CE, com.therawsingh.portfolio.entity.oi.PE PE) {
        this.strikePrice = strikePrice;
        this.expiryDate = expiryDate;
        this.CE = CE;
        this.PE = PE;
    }

    public String getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public com.therawsingh.portfolio.entity.oi.CE getCE() {
        return CE;
    }

    public void setCE(com.therawsingh.portfolio.entity.oi.CE CE) {
        this.CE = CE;
    }

    public com.therawsingh.portfolio.entity.oi.PE getPE() {
        return PE;
    }

    public void setPE(com.therawsingh.portfolio.entity.oi.PE PE) {
        this.PE = PE;
    }
}
