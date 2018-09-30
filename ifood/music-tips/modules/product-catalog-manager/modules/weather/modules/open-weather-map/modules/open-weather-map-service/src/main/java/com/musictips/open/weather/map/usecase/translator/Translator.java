package com.musictips.open.weather.map.usecase.translator;

public interface Translator<From, To> {

    To translate(From from);

}
