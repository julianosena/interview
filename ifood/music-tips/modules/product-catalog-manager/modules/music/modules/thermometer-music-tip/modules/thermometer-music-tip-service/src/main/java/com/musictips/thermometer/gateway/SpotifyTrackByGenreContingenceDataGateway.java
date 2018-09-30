package com.musictips.thermometer.gateway;

import com.musictips.spotify.domain.Track;
import com.musictips.thermometer.gateway.database.model.SpotifyTrackByGenreContingenceData;

import java.util.Collection;

public interface SpotifyTrackByGenreContingenceDataGateway {

    /**
     * Delete all spotify track by genre contingence data
     */
    void deleteAll();

    /**
     * Save an instance
     * @param spotifyTrackByGenreContingenceData
     * @return
     */
    SpotifyTrackByGenreContingenceData save(SpotifyTrackByGenreContingenceData spotifyTrackByGenreContingenceData);

    /**
     * Get all tracks by genre
     * @param genre
     * @return
     */
    Collection<Track> get(String genre);
}