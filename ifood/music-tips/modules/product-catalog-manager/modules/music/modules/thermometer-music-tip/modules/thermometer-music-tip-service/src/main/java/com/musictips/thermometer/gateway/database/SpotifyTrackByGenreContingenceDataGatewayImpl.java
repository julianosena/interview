package com.musictips.thermometer.gateway.database;

import com.musictips.spotify.domain.Track;
import com.musictips.thermometer.gateway.SpotifyTrackByGenreContingenceDataGateway;
import com.musictips.thermometer.gateway.database.model.SpotifyTrackByGenreContingenceData;
import com.musictips.thermometer.gateway.database.repository.SpotifyTrackByGenreContingenceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SpotifyTrackByGenreContingenceDataGatewayImpl implements SpotifyTrackByGenreContingenceDataGateway {

    private final SpotifyTrackByGenreContingenceDataRepository repository;

    @Autowired
    public SpotifyTrackByGenreContingenceDataGatewayImpl(SpotifyTrackByGenreContingenceDataRepository repository){
        this.repository = repository;
    }

    /**
     * Delete all music tracks contingence data
     *
     * @return music genre
     */
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public SpotifyTrackByGenreContingenceData save(SpotifyTrackByGenreContingenceData spotifyTrackByGenreContingenceData) {
        return repository.save(spotifyTrackByGenreContingenceData);
    }

    /**
     * Returns contingence data by genre
     *
     * @return Collection
     */
    @Override
    public Collection<Track> get(String genre) {
        return repository.findAll().stream().findFirst().get().getTracks().get(genre);
    }
}