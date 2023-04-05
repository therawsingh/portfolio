package com.therawsingh.portfolio.entity.oi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TotalPosition {

    @JsonProperty("totOI")
    private long totOI;

    public TotalPosition() {
    }

    public TotalPosition(long totOI) {
        this.totOI = totOI;
    }

    public long getTotOI() {
        return totOI;
    }

    public void setTotOI(long totOI) {
        this.totOI = totOI;
    }

}
