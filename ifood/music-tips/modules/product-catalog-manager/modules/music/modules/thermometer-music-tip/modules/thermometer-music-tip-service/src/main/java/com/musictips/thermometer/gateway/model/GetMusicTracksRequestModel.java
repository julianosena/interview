package com.musictips.thermometer.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musictips.thermometer.gateway.model.validator.GetMusicTracksRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@GetMusicTracksRequest
public class GetMusicTracksRequestModel implements Serializable {

    private static final long serialVersionUID = -6337748994807328304L;

    @JsonProperty("cityName")
    private String cityName;

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("long")
    private String lon;
}
