package com.musictips.thermometer.config;

import com.musictips.spotify.config.SpotifyContingenceByGenre;
import com.musictips.spotify.domain.Track;
import com.musictips.thermometer.gateway.SpotifyTrackByGenreContingenceDataGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.function.Function;

@Configuration
public class SpotifyConfig {

    private SpotifyContingenceByGenre spotifyContingenceByGenre;
    private SpotifyTrackByGenreContingenceDataGateway spotifyTrackByGenreContingenceDataGateway;

    @Autowired
    public SpotifyConfig(SpotifyContingenceByGenre spotifyContingenceByGenre, SpotifyTrackByGenreContingenceDataGateway spotifyTrackByGenreContingenceDataGateway) {
        this.spotifyContingenceByGenre = spotifyContingenceByGenre;
        this.spotifyTrackByGenreContingenceDataGateway = spotifyTrackByGenreContingenceDataGateway;
    }

    @PostConstruct
    public void contingence(){
        spotifyContingenceByGenre.setFunction(new Function<String, Collection<Track>>(){

            /**
             * Applies this function to the given argument.
             *
             * @param s the function argument
             * @return the function result
             */
            @Override
            public Collection<Track> apply(String genre) {
                return spotifyTrackByGenreContingenceDataGateway.get(genre);
            }
        });
    }

}
