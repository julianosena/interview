package com.musictips.open.weather.map.gateway;

import com.musictips.open.weather.map.config.feign.client.configuration.OpenWeatherMapApiFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;

@FeignClient(name = "open-weather-map", url = "https://api.openweathermap.org",
    configuration = OpenWeatherMapApiFeignClientConfiguration.class)
public interface OpenWeatherMapApiFeignClientGateway {

    @RequestMapping(method = RequestMethod.GET, value = "data/2.5/weather?units=metric", consumes = "application/json")
    LinkedHashMap<Object, Object> searchByQuery(@RequestParam("q") String query);

    @RequestMapping(method = RequestMethod.GET, value = "data/2.5/weather?units=metric", consumes = "application/json")
    LinkedHashMap<Object, Object> searchByLatitudeAndLongitude(@RequestParam("lat") String lat, @RequestParam("lon") String lon);
}
