package com.therawsingh.portfolio.entity.oi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    @JsonProperty("data")
    private ArrayList<Data> data;
    @JsonProperty("CE")
    private TotalPosition CE;
    @JsonProperty("PE")
    private TotalPosition PE;

    public Response() {
    }

    public Response(ArrayList<Data> data, TotalPosition CE, TotalPosition PE) {
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

    public TotalPosition getCE() {
        return CE;
    }

    public void setCE(TotalPosition CE) {
        this.CE = CE;
    }

    public TotalPosition getPE() {
        return PE;
    }

    public void setPE(TotalPosition PE) {
        this.PE = PE;
    }
}
