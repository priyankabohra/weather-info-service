package com.example.weatherinfo.rest.v1.resources;

import com.example.weatherinfo.exceptions.type.EntityNotFoundException;
import com.example.weatherinfo.services.WeatherInfoService;
import com.example.weatherinfo.util.MessageUtil;
import com.example.weatherinfo.v1.model.json.WeatherInfoJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/v1/weather-info/")
public class WeatherInfoResource {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final WeatherInfoService weatherInfoService;

  @Autowired
  public WeatherInfoResource(WeatherInfoService weatherInfoService) {
    this.weatherInfoService = weatherInfoService;
  }

  /**
   * Takes city name as input parameter and return json object
   *
   * @param cityName
   * @return WeatherInfoJson
   *
   */
  @GetMapping(value = "/city")
  private WeatherInfoJson findWeatherInfoByCityName(@RequestParam("name") final String cityName) {
    logger.info("findWeatherInfoByCityName called in WeatherInfoResource,  CityName={}", cityName);
    if (cityName.isBlank()) {
      throw new EntityNotFoundException(cityName + MessageUtil.IS_REQUIRED);
    }
    return WeatherInfoJson.toJson(weatherInfoService.findWeatherInfoByCityName(cityName));
  }


}
