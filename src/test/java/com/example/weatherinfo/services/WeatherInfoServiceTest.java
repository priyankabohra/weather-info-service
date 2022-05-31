package com.example.weatherinfo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import com.example.weatherinfo.TestData;
import com.example.weatherinfo.config.WeatherConfig;
import com.example.weatherinfo.v1.model.WeatherInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class WeatherInfoServiceTest {

  @Mock
  private RestTemplate restTemplate;

  @Mock
  private WeatherConfig weatherConfig;

  @InjectMocks
  private WeatherInfoService weatherInfoService;

  private final WeatherInfo expectedWeatherInfo = TestData.getWeatherInfo();

  @Test
  public void findWeatherInfoByCityName_shouldReturn_weatherInfo(){
      final double DELTA = 1e-15;
      when(weatherConfig.getId()).thenReturn("123");
      when(weatherConfig.getUrl()).thenReturn("http://localhost:8080/rest");
      when(weatherConfig.getId()).thenReturn("123");
      when(restTemplate.getForObject("http://localhost:8080/rest?APPID=123&units&q=Stockholm",WeatherInfo.class)).thenReturn(expectedWeatherInfo);
      WeatherInfo weatherInfo= weatherInfoService.findWeatherInfoByCityName("Stockholm");
      assertEquals(expectedWeatherInfo.getCityName(), weatherInfo.getCityName());
      assertEquals(expectedWeatherInfo.getCountryInfo().getCountry(), weatherInfo.getCountryInfo().getCountry());
      assertEquals(expectedWeatherInfo.getTemperatureInfo().getTemperature(),weatherInfo.getTemperatureInfo().getTemperature(), DELTA);
      assertEquals(expectedWeatherInfo.getWeathers().get(0).getWeather(), weatherInfo.getWeathers().get(0).getWeather());
  }

}
