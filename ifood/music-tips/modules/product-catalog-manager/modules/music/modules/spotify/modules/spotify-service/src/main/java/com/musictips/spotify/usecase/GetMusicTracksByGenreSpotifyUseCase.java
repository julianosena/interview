package com.musictips.spotify.usecase;


import com.musictips.spotify.domain.Track;
import com.musictips.spotify.gateway.SpotifySearchApiFeignClientGateway;
import com.musictips.spotify.usecase.translator.Translator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class GetMusicTracksByGenreSpotifyUseCase {

    private SpotifySearchApiFeignClientGateway spotifySearchApiFeignClientGateway;
    private Translator<LinkedHashMap<Object, Object>, List<Track>> translator;

    public GetMusicTracksByGenreSpotifyUseCase(SpotifySearchApiFeignClientGateway spotifySearchApiFeignClientGateway, Translator<LinkedHashMap<Object, Object>, List<Track>> translator){
        this.spotifySearchApiFeignClientGateway = spotifySearchApiFeignClientGateway;
        this.translator = translator;
    }

    /**
     * Call spotify API and transforms objects to domain objects
     * @param genreValue
     * @return Collection<Track>
     */
    public Collection<Track> execute(String genreValue) {
        String query = "genre:\"" + genreValue + "\"";
        LinkedHashMap<Object, Object> spotifySearchApiResponseModel = spotifySearchApiFeignClientGateway.search(query, "track", 40, 0);

        Collection<Track> tracks = translator.translate(spotifySearchApiResponseModel);

        return tracks;
    }

}