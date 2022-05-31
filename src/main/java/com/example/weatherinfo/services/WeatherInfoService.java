package com.example.weatherinfo.services;

import com.example.weatherinfo.config.WeatherConfig;
import com.example.weatherinfo.exceptions.type.EntityNotFoundException;
import com.example.weatherinfo.util.MessageUtil;
import com.example.weatherinfo.v1.model.WeatherInfo;
import com.example.weatherinfo.util.WeatherInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherInfoService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final RestTemplate restTemplate;
  private final WeatherConfig weatherConfig;

  @Autowired
  public WeatherInfoService(final RestTemplate restTemplate, final WeatherConfig weatherConfig) {
    this.restTemplate = restTemplate;
    this.weatherConfig = weatherConfig;
  }

  /**
   * Request weather api to get whether info
   *
   * @throws EntityNotFoundException when input name is not matched with any city
   */
  public WeatherInfo findWeatherInfoByCityName(final String cityName) {
    try {
      logger.info("findWeatherInfoByCityName method called in service WeatherInfoService,  CityName={}", cityName);
      return restTemplate
          .getForObject(
              WeatherInfoUtil.getWeatherInfoUri(weatherConfig)
                  .queryParam("q", cityName)
                  .toUriString(), WeatherInfo.class);
    } catch (RestClientException e) {
      logger.error("EntityNotFoundException in service WeatherInfoService,  CityName={}", cityName);
      throw new EntityNotFoundException(cityName + MessageUtil.NOT_FOUND);
    }
  }

}
