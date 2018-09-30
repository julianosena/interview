package com.musictips.spotify.config.feign.client.configuration;

import com.musictips.spotify.config.feign.client.interceptor.SpotifyAuthorizeFeignInterceptor;
import feign.Feign;
import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyAuthorizeClientConfiguration {

    private final String CLIENT_ID;
    private final String CLIENT_SECRET;

    public SpotifyAuthorizeClientConfiguration(@Value("${spotify.security.clientId}") String CLIENT_ID, @Value("${spotify.security.clientSecret}") String CLIENT_SECRET){
        this.CLIENT_ID = CLIENT_ID;
        this.CLIENT_SECRET = CLIENT_SECRET;
    }

    @Bean
    public Feign.Builder builder() {

        return new Feign.Builder()
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(new SpotifyAuthorizeFeignInterceptor(CLIENT_ID, CLIENT_SECRET));
    }

}
