package com.musictips.thermometer.gateway;

public interface GetSugestorMusicTrackByTemperatureConfigGateway {

    /**
     * Get sugestor music track temperature config by temperature
     * @param temperature
     * @return music genre
     */
    String execute(Double temperature);

}
