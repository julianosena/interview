package com.musictips.spotify.config.feign.client.interceptor;

import com.musictips.spotify.SpotifyApplicationContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class SpotifyGettingResourcesFeignInterceptor implements RequestInterceptor {

    private final SpotifyApplicationContext spotifyApplicationContext;

    public SpotifyGettingResourcesFeignInterceptor(SpotifyApplicationContext spotifyApplicationContext) {
        this.spotifyApplicationContext = spotifyApplicationContext;
    }

    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Bearer " + spotifyApplicationContext.get("access_token"));
    }
}