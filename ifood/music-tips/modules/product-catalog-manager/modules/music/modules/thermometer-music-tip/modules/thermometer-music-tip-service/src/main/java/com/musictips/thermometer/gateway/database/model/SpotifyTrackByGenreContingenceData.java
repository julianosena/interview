package com.musictips.thermometer.gateway.database.model;

import com.musictips.spotify.domain.Track;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Document(collection = "spotify-contingence-data-by-genre")
@Getter @Setter
@Builder
public class SpotifyTrackByGenreContingenceData implements Serializable {

    private static final long serialVersionUID = 2399746800716408231L;

    @Id
    private String id;

    private Map<String, List<Track>> tracks;
}