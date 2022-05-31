package com.example.weatherinfo.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// To ignore unknown json properties
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureInfo {

    @JsonProperty("temp")
    private double temperature;

    public TemperatureInfo(){
        //JSON
    }
    public TemperatureInfo(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}