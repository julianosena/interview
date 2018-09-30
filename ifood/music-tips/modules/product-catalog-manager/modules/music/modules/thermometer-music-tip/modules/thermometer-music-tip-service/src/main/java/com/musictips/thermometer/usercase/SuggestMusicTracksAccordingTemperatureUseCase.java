package com.musictips.thermometer.usercase;

import com.musictips.spotify.usecase.GetMusicTracksByGenreSpotifyUseCase;
import com.musictips.thermometer.domain.Track;
import com.musictips.thermometer.gateway.GetSugestorMusicTrackByTemperatureConfigGateway;
import com.musictips.thermometer.usercase.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SuggestMusicTracksAccordingTemperatureUseCase {

    private final GetSugestorMusicTrackByTemperatureConfigGateway getMusicGenreAccordingTemperatureGateway;
    private final GetMusicTracksByGenreSpotifyUseCase getMusicTracksByGenreSpotifyUseCase;
    private final Translator<Collection<com.musictips.spotify.domain.Track>, List<Track>> translator;

    @Autowired
    public SuggestMusicTracksAccordingTemperatureUseCase(GetSugestorMusicTrackByTemperatureConfigGateway getMusicGenreAccordingTemperatureGateway, GetMusicTracksByGenreSpotifyUseCase getMusicTracksByGenreSpotifyUseCase, Translator<Collection<com.musictips.spotify.domain.Track>, List<Track>> translator){
        this.getMusicGenreAccordingTemperatureGateway = getMusicGenreAccordingTemperatureGateway;
        this.getMusicTracksByGenreSpotifyUseCase = getMusicTracksByGenreSpotifyUseCase;
        this.translator = translator;
    }

    public Collection<Track> execute(Double temperature) {
        String genre = getMusicGenreAccordingTemperatureGateway.execute(temperature);
        return translator.translate(getMusicTracksByGenreSpotifyUseCase.execute(genre));
    }

}