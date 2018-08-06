package com.julianosena.coursera.algorithm.part.two.domain;

public class TownConnection {

    private Town destiny;
    private int distance;

    public TownConnection(Town destiny, int distance) {
        this.destiny = destiny;
        this.distance = distance;
    }

    public Town destiny(){
        return this.destiny;
    }

    public int distance(){
        return this.distance;
    }
}
