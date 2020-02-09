package com.sapient.weather.forcast.repository;


import com.sapient.weather.forcast.entity.WeatherData;
import com.sapient.weather.forcast.exception.WeatherForecastServiceException;

public interface WeatherAPIRepository {
	WeatherData getForecast(String city) throws WeatherForecastServiceException;

}