package com.musictips.thermometer.gateway.database;

import com.musictips.thermometer.gateway.GetSugestorMusicTrackByTemperatureConfigGateway;
import com.musictips.thermometer.gateway.database.repository.SugestorMusicTrackTemperatureConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSugestorMusicTrackByTemperatureConfigGatewayImpl implements GetSugestorMusicTrackByTemperatureConfigGateway {

    private SugestorMusicTrackTemperatureConfigRepository repository;

    @Autowired
    public GetSugestorMusicTrackByTemperatureConfigGatewayImpl(SugestorMusicTrackTemperatureConfigRepository repository){
        this.repository = repository;
    }

    /**
     * @see GetSugestorMusicTrackByTemperatureConfigGateway#execute(Double)
     */
    public String execute(Double temperature){
        return repository.findByTemperature(temperature).orElse(SugestorMusicTrackTemperatureConfigRepository.DEFAULT_TRACK_GENRE).getGenre();
    }

}