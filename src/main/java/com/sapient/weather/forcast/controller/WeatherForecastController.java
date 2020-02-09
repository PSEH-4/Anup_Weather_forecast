package com.sapient.weather.forcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weather/forecast/")
public class WeatherForecastController {



	@RequestMapping("/")
	public String status() {
		return "Success";
	}

}