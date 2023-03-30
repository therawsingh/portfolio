package com.therawsingh.portfolio.entity.oi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TotalCE {

    private long totOI;

    public TotalCE() {
    }

    public TotalCE(long totOI) {
        this.totOI = totOI;
    }

    public long getTotOI() {
        return totOI;
    }

    public void setTotOI(long totOI) {
        this.totOI = totOI;
    }

}
