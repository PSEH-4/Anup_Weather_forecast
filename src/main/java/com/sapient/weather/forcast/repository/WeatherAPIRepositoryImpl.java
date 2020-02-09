package com.sapient.weather.forcast.repository;

import com.sapient.weather.forcast.entity.WeatherData;
import com.sapient.weather.forcast.exception.WeatherForecastServiceException;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class WeatherAPIRepositoryImpl implements WeatherAPIRepository {

    public WeatherData getForecast(String city) throws WeatherForecastServiceException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=city&mode=json&appid=d2929e9483efc82c82c32ee7e02d563e";
        return restTemplate.getForObject(url.replace("city", city), WeatherData.class);
    }
}