package com.sapient.weather.forcast.util;

import com.sapient.weather.forcast.entity.Weather;
import com.sapient.weather.forcast.entity.WeatherData;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class WeatherForecastPredictor {
    public static final long ONE_DAY_MILLIS = 86400 * 1000;

    public String getNextThreeDaysSuggestion(WeatherData weatherData) {
        List<com.sapient.weather.forcast.entity.List> weatherList = weatherData.getList();

        Date newDate = new Date(new Date().getTime() + (3 * ONE_DAY_MILLIS));

        List<com.sapient.weather.forcast.entity.List> collect = weatherList.stream().filter(
                data -> data.getDtTxt().before(newDate)).collect(Collectors.toList());


        for (com.sapient.weather.forcast.entity.List list : collect) {
            // https://openweathermap.org/forecast5 as per api doc
            if (list.getMain().getTempMax() >= 313) // kelvin to celsius
                return "Use sunscreen lotion";
        }
        for (com.sapient.weather.forcast.entity.List list : collect) {
            for (Weather w : list.getWeather()) {
                if (w.getMain().contains("Rain"))
                    return "Carry umbrella";
            }
        }
        return "Weather conditions are normal";

    }

}