package com.example.weatherinfo.v1.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// To ignore unknown json properties
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInfo {

  @JsonProperty("country")
  private String country;

  public CountryInfo(){
    //JSON
  }
  public CountryInfo(String country) {
    this.country = country;
  }

  public String getCountry() {
    return country;
  }
}
