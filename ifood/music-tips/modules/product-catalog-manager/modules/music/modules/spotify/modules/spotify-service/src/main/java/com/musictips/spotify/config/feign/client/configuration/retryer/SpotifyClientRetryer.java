package com.musictips.spotify.config.feign.client.configuration.retryer;

import feign.RetryableException;
import feign.Retryer;

public class SpotifyClientRetryer extends Retryer.Default {

    /**
     * Retryer for Spotify feign Client
     * @param PERIOD Period period between attempts
     * @param MAX_PERIOD the max period to another retry wait
     * @param MAX_ATTEMPTS maxAttempts max of attemps to retry
     */
    public SpotifyClientRetryer(final int PERIOD, final int MAX_PERIOD,  final int MAX_ATTEMPTS ){
        super(PERIOD, MAX_PERIOD, MAX_ATTEMPTS);
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        super.continueOrPropagate(e);
    }

    @Override
    public Retryer clone() {
        return super.clone();
    }
}