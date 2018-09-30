package com.musictips.spotify.usercase

import spock.lang.Specification;

class GetMusicTracksByGenreSpotifyUseCaseTest extends Specification {

    def "Should return rock music track list"(){

        given: "Rock Music genre"
        String genre = "rock"

        when: "Spotify API is called"

        then: "Music rock tracks should be returned"


    }

}