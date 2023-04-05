package com.therawsingh.portfolio.entity.oi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @JsonProperty("strikePrice")
    private String strikePrice;
    @JsonProperty("expiryDate")
    private String expiryDate;
    @JsonProperty("CE")
    private Position CE;
    @JsonProperty("PE")
    private Position PE;

    public Data() {
    }

    public Data(String strikePrice, String expiryDate, Position CE, Position PE) {
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

    public Position getCE() {
        return CE;
    }

    public void setCE(Position Position) {
        this.CE = CE;
    }

    public Position getPE() {
        return PE;
    }

    public void setPE(Position PE) {
        this.PE = PE;
    }
}
