package com.example.weatherinfo.util;

import com.example.weatherinfo.config.WeatherConfig;
import org.springframework.web.util.UriComponentsBuilder;

public class WeatherInfoUtil {

  private static final String APPID="APPID";
  private static final String UNITS="units";

  /**
   *  Take url, app-id and unit from app configuration and build url
   * @param weatherConfig
   * @return
   */
  public static UriComponentsBuilder getWeatherInfoUri(WeatherConfig weatherConfig) {
    return UriComponentsBuilder
        .fromUriString(weatherConfig.getUrl())
        .queryParam(APPID, weatherConfig.getId())
        .queryParam(UNITS, weatherConfig.getUnits());
  }
}
