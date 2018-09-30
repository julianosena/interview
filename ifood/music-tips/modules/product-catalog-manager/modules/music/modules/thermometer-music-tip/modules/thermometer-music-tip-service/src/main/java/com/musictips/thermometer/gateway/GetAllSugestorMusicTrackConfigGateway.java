package com.musictips.thermometer.gateway;

import com.musictips.thermometer.gateway.database.model.SugestorMusicTrackTemperatureConfig;

import java.util.List;

public interface GetAllSugestorMusicTrackConfigGateway {

    /**
     * Get sugestor music track temperature config by temperature
     * @return music genre
     */
    List<SugestorMusicTrackTemperatureConfig> findAll();

}
