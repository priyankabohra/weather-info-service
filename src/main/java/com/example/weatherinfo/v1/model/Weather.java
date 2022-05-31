package com.example.weatherinfo.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// To ignore unknown json properties
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

  @JsonProperty("id")
  private long id;

  @JsonProperty("main")
  private String weather;

  @JsonProperty("description")
  private String description;

  public Weather(){
    //JSON
  }

  public Weather(long id, String weather, String description){
    super();
    this.id = id;
    this.weather =weather;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public String getWeather() {
    return weather;
  }

  public String getDescription() {
    return description;
  }

}
