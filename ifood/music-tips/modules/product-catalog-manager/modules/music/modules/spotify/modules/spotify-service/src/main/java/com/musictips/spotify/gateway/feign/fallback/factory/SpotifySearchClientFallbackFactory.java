package com.musictips.spotify.gateway.feign.fallback.factory;

import com.musictips.spotify.config.SpotifyContingenceByGenre;
import com.musictips.spotify.gateway.feign.fallback.SpotifySearchClientFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpotifySearchClientFallbackFactory implements FallbackFactory<SpotifySearchClientFallback> {

    private final SpotifyContingenceByGenre spotifyContingenceByGenre;

    @Autowired
    public SpotifySearchClientFallbackFactory(SpotifyContingenceByGenre spotifyContingenceByGenre) {
        this.spotifyContingenceByGenre = spotifyContingenceByGenre;
    }

    /**
     * Returns an instance of the fallback appropriate for the given cause
     *
     * @param cause corresponds to {@link AbstractCommand#getExecutionException()}
     *              often, but not always an instance of {@link FeignException}.
     */
    @Override
    public SpotifySearchClientFallback create(Throwable cause) {
        return new SpotifySearchClientFallback(cause, spotifyContingenceByGenre);
    }
}
