package com.sapient.weather.forcast.service;

import com.sapient.weather.forcast.exception.WeatherForecastServiceException;
import com.sapient.weather.forcast.util.WeatherForecastPredictor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

    @Autowired
    private WeatherAPIService service;

    @Override
    public String getWeatherForeCasteByCity(String city) throws WeatherForecastServiceException {
        WeatherForecastPredictor predictor = new WeatherForecastPredictor();
        return predictor.getNextThreeDaysSuggestion(service.getForecast(city));
    }
}