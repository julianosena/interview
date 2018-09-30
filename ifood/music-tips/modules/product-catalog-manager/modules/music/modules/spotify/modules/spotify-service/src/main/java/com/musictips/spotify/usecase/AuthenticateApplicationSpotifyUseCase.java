package com.musictips.spotify.usecase;

import com.musictips.spotify.SpotifyApplicationContext;
import com.musictips.spotify.gateway.SpotifyAccountApiFeignClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

import static java.lang.String.format;

@Component
public class AuthenticateApplicationSpotifyUseCase {

    @Autowired
    private SpotifyAccountApiFeignClientGateway spotifyAccountApiFeignClientGateway;

    @Autowired
    private SpotifyApplicationContext spotifyApplicationContext;

    /**
     * Call spotify API to get token and authenticate application on Spotify
     * putting access token on application context.
     * @param grantType
     */
    public void execute(String grantType) {
        LinkedHashMap<String, String> response = spotifyAccountApiFeignClientGateway.token(format("grant_type=%s", grantType));
        spotifyApplicationContext.put("access_token", response.get("access_token"));
        spotifyApplicationContext.put("token_type", response.get("token_type"));
        spotifyApplicationContext.put("expires_in", response.get("expires_in"));
    }
}