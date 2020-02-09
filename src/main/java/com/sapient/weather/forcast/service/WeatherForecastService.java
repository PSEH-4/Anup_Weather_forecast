package com.sapient.weather.forcast.service;


import com.sapient.weather.forcast.exception.WeatherForecastServiceException;

public interface WeatherForecastService {

    String getWeatherForeCasteByCity(String city) throws WeatherForecastServiceException;
}