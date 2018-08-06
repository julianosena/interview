package com.julianosena.coursera.algorithm.part.two.usecase;

import com.julianosena.coursera.algorithm.part.two.domain.Town;
import com.julianosena.coursera.algorithm.part.two.domain.exception.TownConnectionInputFormatException;

import java.util.LinkedHashSet;
import java.util.Set;

public class GetAllTownsFromInputTownsConnectionsAndTheirDistancesUseCase {

    private final GetFirstTownFromTownsConnectionAndTheirDistancesUseCase getFirstTownFromTownsConnectionAndTheirDistancesUseCase = new GetFirstTownFromTownsConnectionAndTheirDistancesUseCase();
    private final GetLastTownFromTownsConnectionAndTheirDistancesUseCase getLastTownFromTownsConnectionAndTheirDistancesUseCase = new GetLastTownFromTownsConnectionAndTheirDistancesUseCase();

    public Set<Town> execute(String[] connections) throws TownConnectionInputFormatException {
        Set<Town> towns = new LinkedHashSet<>();
        for(String connection : connections) {
            Town from = getFirstTownFromTownsConnectionAndTheirDistancesUseCase.execute(connection);
            Town to = getLastTownFromTownsConnectionAndTheirDistancesUseCase.execute(connection);

            towns.add(from);
            towns.add(to);
        }

        return towns;
    }
}
