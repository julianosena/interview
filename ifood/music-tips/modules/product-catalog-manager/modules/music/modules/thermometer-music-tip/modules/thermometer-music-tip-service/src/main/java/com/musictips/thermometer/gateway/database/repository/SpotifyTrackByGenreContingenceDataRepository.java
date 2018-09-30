package com.musictips.thermometer.gateway.database.repository;

import com.musictips.thermometer.gateway.database.model.SpotifyTrackByGenreContingenceData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpotifyTrackByGenreContingenceDataRepository extends MongoRepository<SpotifyTrackByGenreContingenceData, String> {

}