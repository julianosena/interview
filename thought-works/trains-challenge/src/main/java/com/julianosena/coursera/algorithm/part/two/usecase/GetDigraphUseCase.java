package com.julianosena.coursera.algorithm.part.two.usecase;

import com.julianosena.coursera.algorithm.part.two.domain.Digraph;
import com.julianosena.coursera.algorithm.part.two.domain.Town;
import com.julianosena.coursera.algorithm.part.two.domain.exception.TownConnectionInputFormatException;

import java.util.Set;

public class GetDigraphUseCase {

    public Digraph execute(final String...input) throws TownConnectionInputFormatException {
        final Set<Town> towns = new GetAllTownsFromInputTownsConnectionsAndTheirDistancesUseCase().execute(input);
        final Digraph digraph = new Digraph(towns);

        for(String connection : input){
            Town from = new GetFirstTownFromTownsConnectionAndTheirDistancesUseCase().execute(connection);
            Town to = new GetLastTownFromTownsConnectionAndTheirDistancesUseCase().execute(connection);
            int distance = new GetDistanceFromTownsConnectionAndTheirDistancesUseCase().execute(connection);
            digraph.addEdge(from, to, distance);
        }

        return digraph;
    }
}
