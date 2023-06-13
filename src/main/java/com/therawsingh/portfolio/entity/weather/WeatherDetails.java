package com.therawsingh.portfolio.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetails {

    private double temperature;
    private double humidity;
    private double precipitation;

    @JsonProperty("weather_descriptions")
    private WeatherDescription[] weatherDescription;

    public WeatherDetails() {
    }

    public WeatherDetails(double temperature, double humidity, double precipitation, WeatherDescription[] weatherDescription) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.weatherDescription = weatherDescription;
    }

    public WeatherDescription[] getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(WeatherDescription[] weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
