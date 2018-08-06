package com.julianosena.coursera.algorithm.part.two.domain;

import com.julianosena.coursera.algorithm.part.two.domain.exception.TownConnectionDoesNotExists;

import java.util.*;

public class Digraph {

    private final Map<Town, List<TownConnection>> TOWNS;

    public Digraph(final Set<Town> TOWNS) {
        this.TOWNS = new LinkedHashMap(TOWNS.size());
        for(final Town TOWN : TOWNS){
            this.TOWNS.put(TOWN, new ArrayList<TownConnection>());
        }
    }

    public void addEdge(Town from, Town to, int distance){
        TownConnection townConnection = new TownConnection(to, distance);

        if(null == TOWNS.get(from)) TOWNS.put(from, new ArrayList<TownConnection>());
        TOWNS.get(from).add(townConnection);
    }

    public Map<Town, List<TownConnection>> towns(){
        return this.TOWNS;
    }

    public int distance(Town from, Town to) throws TownConnectionDoesNotExists {
        return this.TOWNS.get(from).stream()
                .filter(connection -> connection.destiny().equals(to))
                .findFirst()
                .orElseThrow(() -> new TownConnectionDoesNotExists("Rota desejada não existe")).distance();
    }
}