package com.musictips.spotify.config.feign.client.configuration;

import com.musictips.spotify.SpotifyApplicationContext;
import com.musictips.spotify.config.feign.client.configuration.retryer.SpotifyClientRetryer;
import com.musictips.spotify.config.feign.client.interceptor.SpotifyGettingResourcesFeignInterceptor;
import feign.Feign;
import feign.Logger;
import feign.hystrix.HystrixFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifySearchClientConfiguration {

    @Autowired
    private SpotifyApplicationContext spotifyApplicationContext;

    @Value("${spotify.feign.config.retry.period:100}") int PERIOD;
    @Value("${spotify.feign.config.retry.period:1000}") int MAX_PERIOD;
    @Value("${spotify.feign.config.retry.maxAttempts:3}") int MAX_ATTEMPTS;

    @Bean
    public Feign.Builder builder() {
        return new HystrixFeign.Builder()
                .logLevel(Logger.Level.FULL)
                .errorDecoder(new SpotifyClientConfiguration.SpotifyErrorDecoder())
                .retryer(new SpotifyClientRetryer(PERIOD, MAX_PERIOD, MAX_ATTEMPTS))
                .requestInterceptor(new SpotifyGettingResourcesFeignInterceptor(spotifyApplicationContext));
    }
}
