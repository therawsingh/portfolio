package com.therawsingh.portfolio.entity.oi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TotalPE {

    private long totOI;

    public TotalPE() {
    }

    public TotalPE(long totOI) {
        this.totOI = totOI;
    }

    public long getTotOI() {
        return totOI;
    }

    public void setTotOI(long totOI) {
        this.totOI = totOI;
    }

}
