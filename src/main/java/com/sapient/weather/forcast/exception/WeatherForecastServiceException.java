package com.sapient.weather.forcast.exception;

public class WeatherForecastServiceException extends RuntimeException {


    public WeatherForecastServiceException(String message, Throwable t) {
        super(message, t);
    }

}