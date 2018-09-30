package com.musictips.spotify.config.feign.client.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;

public class SpotifyAuthorizeFeignInterceptor implements RequestInterceptor {

    private final String clientId;
    private final String clientSecret;

    public SpotifyAuthorizeFeignInterceptor(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        requestTemplate.header(HttpHeaders.AUTHORIZATION, "Basic " + basicAuthorizationToken());
    }

    /**
     * Crypts a client id and secret
     * @return String
     */
    private String basicAuthorizationToken(){
        final String clientId = this.clientId;
        final String clientSecret = this.clientSecret;
        final String formatted = clientId + ":" + clientSecret;

        final byte[] bytes = Base64Utils.encode(formatted.getBytes());
        return new String(bytes);
    }
}
