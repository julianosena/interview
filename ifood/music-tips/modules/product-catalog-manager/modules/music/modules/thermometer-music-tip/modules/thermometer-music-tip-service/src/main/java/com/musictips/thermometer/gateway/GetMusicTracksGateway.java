package com.musictips.thermometer.gateway;

import com.musictips.open.weather.map.usecase.GetTemperatureByCityNameUseCase;
import com.musictips.open.weather.map.usecase.GetTemperatureByLatitudeAndLongitudeUseCase;
import com.musictips.thermometer.domain.Track;
import com.musictips.thermometer.gateway.model.GetMusicTracksRequestModel;
import com.musictips.thermometer.usercase.SuggestMusicTracksAccordingTemperatureUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("tracks")
public class GetMusicTracksGateway {

    private GetTemperatureByCityNameUseCase getTemperatureByCityNameUseCase;
    private GetTemperatureByLatitudeAndLongitudeUseCase getTemperatureByLatitudeAndLongitudeUseCase;
    private SuggestMusicTracksAccordingTemperatureUseCase suggestMusicTracksAccordingTemperatureUseCase;

    @Autowired
    public GetMusicTracksGateway(GetTemperatureByCityNameUseCase getTemperatureByCityNameUseCase, GetTemperatureByLatitudeAndLongitudeUseCase getTemperatureByLatitudeAndLongitudeUseCase, SuggestMusicTracksAccordingTemperatureUseCase suggestMusicTracksAccordingTemperatureUseCase){
        this.getTemperatureByCityNameUseCase = getTemperatureByCityNameUseCase;
        this.getTemperatureByLatitudeAndLongitudeUseCase = getTemperatureByLatitudeAndLongitudeUseCase;
        this.suggestMusicTracksAccordingTemperatureUseCase = suggestMusicTracksAccordingTemperatureUseCase;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Track>> getTracksByCityName(@Valid GetMusicTracksRequestModel request){

        Double temperature;
        if(!isEmpty(request.getCityName()))
            temperature = getTemperatureByCityNameUseCase.execute(request.getCityName());
        else
            temperature = getTemperatureByLatitudeAndLongitudeUseCase.execute(request.getLat(), request.getLon());

        List<Track> tracks = (List<Track>) suggestMusicTracksAccordingTemperatureUseCase.execute(temperature);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }
}
