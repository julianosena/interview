package com.musictips.thermometer.usercase;

import com.musictips.spotify.domain.Track;
import com.musictips.spotify.usecase.GetMusicTracksByGenreSpotifyUseCase;
import com.musictips.thermometer.gateway.GetAllSugestorMusicTrackConfigGateway;
import com.musictips.thermometer.gateway.SpotifyTrackByGenreContingenceDataGateway;
import com.musictips.thermometer.gateway.database.model.SpotifyTrackByGenreContingenceData;
import com.musictips.thermometer.gateway.database.model.SugestorMusicTrackTemperatureConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CreateSpotifyContingenceDataUseCase {

    private final SpotifyTrackByGenreContingenceDataGateway spotifyTrackByGenreContingenceDataGateway;
    private final GetAllSugestorMusicTrackConfigGateway getAllSugestorMusicTrackConfigGateway;
    private final GetMusicTracksByGenreSpotifyUseCase getMusicTracksByGenreSpotifyUseCase;

    @Autowired
    public CreateSpotifyContingenceDataUseCase(SpotifyTrackByGenreContingenceDataGateway spotifyTrackByGenreContingenceDataGateway, GetAllSugestorMusicTrackConfigGateway getAllSugestorMusicTrackConfigGateway, GetMusicTracksByGenreSpotifyUseCase getMusicTracksByGenreSpotifyUseCase) {
        this.spotifyTrackByGenreContingenceDataGateway = spotifyTrackByGenreContingenceDataGateway;
        this.getAllSugestorMusicTrackConfigGateway = getAllSugestorMusicTrackConfigGateway;
        this.getMusicTracksByGenreSpotifyUseCase = getMusicTracksByGenreSpotifyUseCase;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void execute(){
        spotifyTrackByGenreContingenceDataGateway.deleteAll();
        SpotifyTrackByGenreContingenceData spotifyTrackByGenreContingenceData = spotifyTrackByGenreContingenceDataGateway.save(SpotifyTrackByGenreContingenceData.builder().build());

        List<SugestorMusicTrackTemperatureConfig> configs = getAllSugestorMusicTrackConfigGateway.findAll();
        configs.stream().forEach((config) -> {
            Collection<Track> tracks = getMusicTracksByGenreSpotifyUseCase.execute(config.getGenre());
            spotifyTrackByGenreContingenceData.getTracks().put(config.getGenre(), (List<Track>) tracks);
        });
    }

}
