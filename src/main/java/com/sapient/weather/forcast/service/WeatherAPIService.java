package com.sapient.weather.forcast.service;

import com.sapient.weather.forcast.entity.WeatherData;
import com.sapient.weather.forcast.exception.WeatherForecastServiceException;

public interface WeatherAPIService {
	WeatherData getForecast(String city) throws WeatherForecastServiceException;

}