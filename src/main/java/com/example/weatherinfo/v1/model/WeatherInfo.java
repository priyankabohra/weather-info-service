package com.example.weatherinfo.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

  @JsonProperty("id")
  private long id;

  @JsonProperty("main")
  private TemperatureInfo temperatureInfo;

  @JsonProperty("name")
  private String cityName;

  @JsonProperty("sys")
  private CountryInfo countryInfo;

  @JsonProperty("weather")
  private List<Weather> weathers;

  public WeatherInfo(){
    //JSON
  }

  public WeatherInfo(long id, TemperatureInfo temperatureInfo, String cityName,
                     CountryInfo countryInfo, List<Weather> weathers) {
    super();
    this.id = id;
    this.temperatureInfo = temperatureInfo;
    this.cityName = cityName;
    this.countryInfo = countryInfo;
    this.weathers = weathers;
  }


  public long getId() {
    return id;
  }

  public TemperatureInfo getTemperatureInfo() {
    return temperatureInfo;
  }

  public String getCityName() {
    return cityName;
  }

  public CountryInfo getCountryInfo() {
    return countryInfo;
  }

  public List<Weather> getWeathers() {
    return weathers;
  }
}
