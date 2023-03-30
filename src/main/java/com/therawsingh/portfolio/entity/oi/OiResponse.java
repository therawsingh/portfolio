package com.therawsingh.portfolio.entity.oi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OiResponse {

    @JsonProperty("filtered")
    private Response filtered;

    public OiResponse() {
    }

    public OiResponse(Response filtered) {
        this.filtered = filtered;
    }

    public Response getFiltered() {
        return filtered;
    }

    public void setFiltered(Response filtered) {
        this.filtered = filtered;
    }

}
