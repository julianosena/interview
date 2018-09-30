package com.musictips.thermometer.gateway.database;

import com.musictips.thermometer.gateway.GetAllSugestorMusicTrackConfigGateway;
import com.musictips.thermometer.gateway.database.model.SugestorMusicTrackTemperatureConfig;
import com.musictips.thermometer.gateway.database.repository.SugestorMusicTrackTemperatureConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllSugestorMusicTrackConfigGatewayImpl implements GetAllSugestorMusicTrackConfigGateway {

    private SugestorMusicTrackTemperatureConfigRepository repository;

    @Autowired
    public GetAllSugestorMusicTrackConfigGatewayImpl(SugestorMusicTrackTemperatureConfigRepository repository){
        this.repository = repository;
    }

    /**
     * Get sugestor music track temperature config by temperature
     *
     * @return music genre
     */
    @Override
    public List<SugestorMusicTrackTemperatureConfig> findAll() {
        return repository.findAll();
    }
}