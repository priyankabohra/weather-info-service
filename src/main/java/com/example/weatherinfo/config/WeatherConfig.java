package com.example.weatherinfo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("weatherapi")
public class WeatherConfig {

  private  String id;
  private  String url;
  private  String units;

  public String getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public String getUnits() {
    return units;
  }

  // Setter property is needed in order to take value form property file
  public void setId(String id) {
    this.id = id;
  }

  // Setter property is needed in order to take value form property file
  public void setUrl(String url) {
    this.url = url;
  }

  // Setter property is needed in order to take value form property file
  public void setUnits(String units) {
    this.units = units;
  }
}
