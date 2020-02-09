package com.sapient.weather.forcast.controller;

import com.sapient.weather.forcast.exception.WeatherForecastServiceException;
import com.sapient.weather.forcast.service.WeatherForecastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/weather")
public class WeatherForecastController {


    @RequestMapping("/")
    public String status() {
        return "success";
    }


    private static Logger logger = LoggerFactory.getLogger(WeatherForecastController.class);

    @Autowired
    private WeatherForecastService weatherForecastService;

    @GetMapping("/forecast/{city}")
    public String forecastByCity(@NotNull @PathVariable("city") String city) throws WeatherForecastServiceException {
        logger.info("forecast requested by city {}", city);
        return weatherForecastService.getWeatherForeCasteByCity(city);
    }

//    @GetMapping("/forecast/{city}/{country}")
//    public String forecastByCityAndCountryCode(@NotNull @PathVariable("city") String city,
//                                               @NotNull @PathVariable("country") String country) throws WeatherForecastServiceException {
//        logger.info("forecast requested by city and country {}, {}", city, country);
//        return weatherForecastService.getWeatherAnalysis(city, country);
//    }

}