package com.therawsingh.portfolio.entity.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDetails {

    private long amount;
    private String from;
    private String to;

    public CurrencyDetails() {
    }

    public CurrencyDetails(long amount, String from, String to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
