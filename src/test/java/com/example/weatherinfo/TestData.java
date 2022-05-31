package com.example.weatherinfo;

import com.example.weatherinfo.v1.model.CountryInfo;
import com.example.weatherinfo.v1.model.TemperatureInfo;
import com.example.weatherinfo.v1.model.Weather;
import com.example.weatherinfo.v1.model.WeatherInfo;
import java.util.List;

public class TestData {

  public static WeatherInfo getWeatherInfo(){
    TemperatureInfo temperatureInfo = new TemperatureInfo(10.3);
    CountryInfo countryInfo = new CountryInfo("Sweden");
    List<Weather> weathers = List.of(new Weather(500, "Sunny", "Sunny"));
    return new WeatherInfo(123, temperatureInfo, "Stockholm", countryInfo, weathers);
  }
}
