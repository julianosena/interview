package com.musictips.open.weather.map.config.feign.client.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class OpenWeatherMapGettingResourcesFeignInterceptor implements RequestInterceptor {

    private final String APPID;

    public OpenWeatherMapGettingResourcesFeignInterceptor(String appId){
        this.APPID = appId;
    }

    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.query("APPID", APPID);
    }
}