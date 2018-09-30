package com.musictips.spotify.config;

import com.musictips.spotify.domain.Track;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Function;

@Builder
@Getter @Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class SpotifyContingenceByGenre {

    Function<String, Collection<Track>> function;

}