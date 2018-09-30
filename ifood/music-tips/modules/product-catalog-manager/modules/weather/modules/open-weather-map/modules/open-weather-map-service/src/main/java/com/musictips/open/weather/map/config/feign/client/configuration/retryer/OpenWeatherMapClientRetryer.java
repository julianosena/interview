package com.musictips.open.weather.map.config.feign.client.configuration.retryer;

import feign.RetryableException;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;

public class OpenWeatherMapClientRetryer extends Retryer.Default {

    /**
     * Retryer for Open Weather Map Client feign Client
     * @param PERIOD Period period between attempts
     * @param MAX_PERIOD the max period to another retry wait
     * @param MAX_ATTEMPTS maxAttempts max of attemps to retry
     */
    public OpenWeatherMapClientRetryer(final int PERIOD, final int MAX_PERIOD, final int MAX_ATTEMPTS ){
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