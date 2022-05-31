package com.example.weatherinfo.resources;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.example.weatherinfo.TestData;
import com.example.weatherinfo.services.WeatherInfoService;
import com.example.weatherinfo.v1.model.WeatherInfo;
import com.example.weatherinfo.v1.model.json.WeatherInfoJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WeatherInfoResourceTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private WeatherInfoService weatherInfoService;

  private final WeatherInfo weatherInfo = TestData.getWeatherInfo();

  @Test
  public void findWeatherInfoByCityName_shouldReturn_weatherInfoJson() throws Exception {
    final WeatherInfoJson weatherInfoJson = WeatherInfoJson.toJson(weatherInfo);
    when(weatherInfoService.findWeatherInfoByCityName(Mockito.anyString()))
        .thenReturn(weatherInfo);
    mvc.perform(get("/rest/v1/weather-info/city?name=" + weatherInfo.getCityName())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.temperature", is(weatherInfoJson.getTemperature())))
        .andExpect(jsonPath("$.country", is(weatherInfoJson.getCountry())))
        .andExpect(jsonPath("$.city", is(weatherInfoJson.getCity())))
        .andExpect(jsonPath("$.weather", is(weatherInfoJson.getWeather())));
  }


  @Test
  public void findWeatherInfoByCityName_shouldReturn_badRequest_whenBlank() throws Exception {
    mvc.perform(get("/rest/v1/weather-info/city?name=")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

}
