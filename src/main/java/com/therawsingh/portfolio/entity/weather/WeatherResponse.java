package com.therawsingh.portfolio.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("location")
    private Location location;

    @JsonProperty("current")
    private WeatherDetails current;

    public WeatherResponse() {
    }

    public WeatherResponse(Location location, WeatherDetails current) {
        this.location = location;
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public WeatherDetails getCurrent() {
        return current;
    }

    public void setCurrent(WeatherDetails current) {
        this.current = current;
    }
}
