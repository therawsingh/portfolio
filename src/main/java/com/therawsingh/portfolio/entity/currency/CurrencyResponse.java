package com.therawsingh.portfolio.entity.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {

    private CurrencyDetails query;

    private long result;

    public CurrencyResponse() {
    }

    public CurrencyResponse(CurrencyDetails query, long result) {
        this.query = query;
        this.result = result;
    }

    public CurrencyDetails getQuery() {
        return query;
    }

    public void setQuery(CurrencyDetails query) {
        this.query = query;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }
}
