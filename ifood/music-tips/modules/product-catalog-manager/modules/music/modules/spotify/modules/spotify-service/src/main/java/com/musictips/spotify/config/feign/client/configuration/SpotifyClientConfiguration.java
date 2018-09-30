package com.musictips.spotify.config.feign.client.configuration;

import feign.Response;
import feign.codec.ErrorDecoder;

public class SpotifyClientConfiguration {

    /**
     * Decoder for all Spotify clients
     */
    public static class SpotifyErrorDecoder extends ErrorDecoder.Default {

        @Override
        public Exception decode(String methodKey, Response response) {
            return super.decode(methodKey, response);
        }
    }

}
