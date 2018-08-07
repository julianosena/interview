package com.julianosena.coursera.algorithm.part.two.domain;

import java.util.LinkedList;

public class Route implements Comparable<Route> {

    private LinkedList<Town> towns;
    private Integer distance;

    public Route() {
        this.towns = new LinkedList<>();
        this.distance = 0;
    }

    public void addTown(Town town, int distance){
        this.towns.add(town);
        this.distance += distance;
    }

    public int distance(){
        return this.distance;
    }


    @Override
    public int compareTo(Route o) {
        return this.distance.compareTo(o.distance);
    }
}
