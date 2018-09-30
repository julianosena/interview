package com.musictips.open.weather.map;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.musictips.open.weather.map.gateway")
public class OpenWeatherMapClientApplication {

}