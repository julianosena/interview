package com.musictips.open.weather.map.config.feign.client.configuration;

import com.musictips.open.weather.map.config.feign.client.configuration.retryer.OpenWeatherMapClientRetryer;
import com.musictips.open.weather.map.config.feign.client.interceptor.OpenWeatherMapGettingResourcesFeignInterceptor;
import feign.Feign;
import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenWeatherMapApiFeignClientConfiguration {

    @Value("${open.weather.map.app.key}") String APP_ID;

    @Value("${open.weather.map.feign.config.retry.period:100}") int PERIOD;
    @Value("${open.weather.map.feign.config.retry.period:1000}") int MAX_PERIOD;
    @Value("${open.weather.map.feign.config.retry.maxAttempts:3}") int MAX_ATTEMPTS;

    public OpenWeatherMapApiFeignClientConfiguration(){}

    @Bean
    public Feign.Builder builder() {
        return new Feign.Builder()
                .logLevel(Logger.Level.FULL)
                .retryer(new OpenWeatherMapClientRetryer(PERIOD, MAX_PERIOD, MAX_ATTEMPTS))
                .requestInterceptor(new OpenWeatherMapGettingResourcesFeignInterceptor(APP_ID));
    }
}
