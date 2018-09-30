package com.musictips.spotify.gateway.feign.fallback;

import com.musictips.spotify.config.SpotifyContingenceByGenre;
import com.musictips.spotify.domain.Track;
import com.musictips.spotify.gateway.SpotifySearchApiFeignClientGateway;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

public class SpotifySearchClientFallback implements SpotifySearchApiFeignClientGateway {

    private final Throwable cause;
    private final SpotifyContingenceByGenre spotifyContingenceByGenre;

    public SpotifySearchClientFallback(Throwable cause, SpotifyContingenceByGenre spotifyContingenceByGenre) {
        this.cause = cause;
        this.spotifyContingenceByGenre = spotifyContingenceByGenre;
    }

    @Override
    public LinkedHashMap<Object, Object> search(String query, String type, Integer limit, Integer offset) {
        LinkedHashMap<Object, Object> spotifySearchApiResponseModel = new LinkedHashMap<>();
        spotifySearchApiResponseModel.put("tracks", new LinkedHashMap<>());

        ((LinkedHashMap) spotifySearchApiResponseModel.get("tracks")).put("items", new ArrayList<>());

        Collection<Track> tracks = spotifyContingenceByGenre.getFunction().apply(query);
        tracks.stream().forEach(track -> {
            LinkedHashMap<String, String> item = new LinkedHashMap<>();
            item.put("name", track.getName());
            ((ArrayList)((LinkedHashMap) spotifySearchApiResponseModel.get("tracks")).get("items")).add(item);
        });

        return spotifySearchApiResponseModel;
    }
}