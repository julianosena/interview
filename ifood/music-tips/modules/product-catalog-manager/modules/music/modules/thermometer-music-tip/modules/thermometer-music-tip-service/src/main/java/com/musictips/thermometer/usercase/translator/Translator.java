package com.musictips.thermometer.usercase.translator;

public interface Translator<From, To> {

    To translate(From from);

}
