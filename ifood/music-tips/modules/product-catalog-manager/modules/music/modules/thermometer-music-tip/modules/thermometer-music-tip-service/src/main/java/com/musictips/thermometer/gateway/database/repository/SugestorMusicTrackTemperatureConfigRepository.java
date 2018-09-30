package com.musictips.thermometer.gateway.database.repository;

import com.musictips.thermometer.gateway.database.model.SugestorMusicTrackTemperatureConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface SugestorMusicTrackTemperatureConfigRepository extends MongoRepository<SugestorMusicTrackTemperatureConfig, String> {

    SugestorMusicTrackTemperatureConfig DEFAULT_TRACK_GENRE = SugestorMusicTrackTemperatureConfig
            .temperature()
                .range().start(10D).end(14D)
            .genre("rock")
            .build();

    @Query("{ 'rangeOfTemperatures.start' : { $lte: ?0 }, 'rangeOfTemperatures.end': { $gte: ?0 } }}")
    Optional<SugestorMusicTrackTemperatureConfig> findByTemperature(Double temperature);

}