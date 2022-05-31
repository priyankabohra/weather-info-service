package com.example.weatherinfo.v1.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.weatherinfo.util.MessageUtil;
import com.example.weatherinfo.v1.model.Weather;
import com.example.weatherinfo.v1.model.WeatherInfo;

public class WeatherInfoJson {

  @JsonProperty
  private long id;

  @JsonProperty
  private double temperature;

  @JsonProperty
  private String country;

  @JsonProperty
  private String city;

  @JsonProperty
  private String weather;

  public WeatherInfoJson() {
    //JSON
  }

  public WeatherInfoJson(long id, double temperature, String country, String city, String weather) {
    this.id = id;
    this.temperature = temperature;
    this.country = country;
    this.city = city;
    this.weather = weather;
  }

  public long getId() {
    return id;
  }

  public double getTemperature() {
    return temperature;
  }

  public String getCountry() {
    return country;
  }

  public String getCity() {
    return city;
  }

  public String getWeather() {
    return weather;
  }

  /**
   * Takes Raw weather info then transform and return into json
   * @param weatherInfo
   * @return
   */
  public static WeatherInfoJson toJson(final WeatherInfo weatherInfo) {
    return new WeatherInfoJson(weatherInfo.getId(),
        weatherInfo.getTemperatureInfo().getTemperature(),
        weatherInfo.getCountryInfo().getCountry(),
        weatherInfo.getCityName(),
        weatherInfo.getWeathers().stream().findFirst()
            .orElse(new Weather(0, MessageUtil.NOT_FOUND, MessageUtil.NOT_FOUND)).getWeather());
  }

}
