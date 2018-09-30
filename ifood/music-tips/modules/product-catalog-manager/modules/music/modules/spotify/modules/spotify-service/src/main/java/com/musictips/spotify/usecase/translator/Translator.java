package com.musictips.spotify.usecase.translator;

public interface Translator<From, To> {

    To translate(From from);

}
