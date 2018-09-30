package com.musictips.thermometer.usecase

import spock.lang.Specification

class SuggestMusicTracksAccordingTemperatureUseCaseSpec extends Specification {

    def "Should suggest rock music tracks in temperature is between 10 and 14 degrees"() {

        given: "the temperature is between 10 and 14 degrees"
        Integer temperature = 10;

        when: "thermometer config is called, the kind of music tracks should be rock"


        then: "spotify is called to get rock music tracks"

        and: "it should be called once"
        1 * spotifyClient.playlist()

        and: "return a rock music tracks"
        List tracks = spotifyClient.playlist()
        tracks != null
        tracks.forEach(track.type == ROCK)
    }

}