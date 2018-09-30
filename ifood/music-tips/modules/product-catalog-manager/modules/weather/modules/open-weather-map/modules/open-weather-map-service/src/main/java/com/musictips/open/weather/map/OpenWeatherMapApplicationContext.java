package com.musictips.open.weather.map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Component
@Scope(SCOPE_SINGLETON)
public class OpenWeatherMapApplicationContext {

    private final Map<String, String> context = new HashMap<String, String>();

    public String get(String key){
        return this.context.get(key);
    }

    public void put(String key, String value){
        this.context.put(key, value);
    }
}
