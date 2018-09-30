package com.musictips.thermometer.usercase.translator.impl;

import com.musictips.thermometer.domain.Track;
import com.musictips.thermometer.usercase.translator.Translator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpotifyClientTrackModelListToThermometerMusicTipTrackModelListTranslator implements Translator<Collection<com.musictips.spotify.domain.Track>, List<Track>> {

    @Override
    public List<Track> translate(Collection<com.musictips.spotify.domain.Track> tracks) {
        return tracks.stream().map(spotifyTrack -> {
            return Track.builder()
                    .name(spotifyTrack.getName())
                    .build();
        }).collect(Collectors.toList());
    }
}
