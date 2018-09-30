package com.musictips.spotify.usecase.translator.impl;

import com.musictips.spotify.domain.Track;
import com.musictips.spotify.usecase.translator.Translator;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpotifySearchApiResponseModelToTrackListDomainTranslator implements Translator<LinkedHashMap<Object, Object>, List<Track>> {

    public List<Track> translate(LinkedHashMap<Object, Object> spotifySearchApiModel) {

        LinkedHashMap<Object, Object> spotifySearchResponseApiTracksModel = (LinkedHashMap<Object, Object>) spotifySearchApiModel.get("tracks");
        List<LinkedHashMap<Object, Object>> items = (List<LinkedHashMap<Object, Object>>) spotifySearchResponseApiTracksModel.get("items");

        return items.stream().map(item -> {
            return Track.builder()
                .name((String) item.get("name"))
                .build();
        }).collect(Collectors.toList());
    }
}
