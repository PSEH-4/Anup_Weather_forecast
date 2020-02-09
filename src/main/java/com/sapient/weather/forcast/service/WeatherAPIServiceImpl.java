package com.sapient.weather.forcast.service;

import com.sapient.weather.forcast.entity.WeatherData;
import com.sapient.weather.forcast.exception.WeatherForecastServiceException;
import com.sapient.weather.forcast.repository.WeatherAPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherAPIServiceImpl implements WeatherAPIService {

	@Autowired
	private WeatherAPIRepository weatherAPIRepository;
	
	@Override
	public WeatherData getForecast(String city) throws WeatherForecastServiceException {
		return weatherAPIRepository.getForecast(city);
	}

}