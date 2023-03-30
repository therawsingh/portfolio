package com.therawsingh.portfolio.entity.oi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private ArrayList<Data> data;
    private TotalCE CE;
    private TotalPE PE;

    public Response() {
    }

    public Response(ArrayList<Data> data, TotalCE CE, TotalPE PE) {
        this.data = data;
        this.CE = CE;
        this.PE = PE;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public TotalCE getCE() {
        return CE;
    }

    public void setCE(TotalCE CE) {
        this.CE = CE;
    }

    public TotalPE getPE() {
        return PE;
    }

    public void setPE(TotalPE PE) {
        this.PE = PE;
    }
}
