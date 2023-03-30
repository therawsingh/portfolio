package com.therawsingh.portfolio.entity.oi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CE {

    private int strikePrice;
    private String expiryDate;
    private long openInterest;
    private long changeinOpenInterest;

    public CE() {
    }

    public CE(int strikePrice, String expiryDate, long openInterest, long changeinOpenInterest) {
        this.strikePrice = strikePrice;
        this.expiryDate = expiryDate;
        this.openInterest = openInterest;
        this.changeinOpenInterest = changeinOpenInterest;
    }

    public int getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(int strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public long getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(long openInterest) {
        this.openInterest = openInterest;
    }

    public long getChangeinOpenInterest() {
        return changeinOpenInterest;
    }

    public void setChangeinOpenInterest(long changeinOpenInterest) {
        this.changeinOpenInterest = changeinOpenInterest;
    }
}
