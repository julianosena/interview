package com.julianosena.coursera.algorithm.part.two.usecase;

import com.julianosena.coursera.algorithm.part.two.domain.Digraph;
import com.julianosena.coursera.algorithm.part.two.domain.Town;
import com.julianosena.coursera.algorithm.part.two.domain.exception.RouteInputFormatException;
import com.julianosena.coursera.algorithm.part.two.domain.exception.TownConnectionDoesNotExists;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetDistanceFromRouteUseCase {

    private final Pattern PATTERN = Pattern.compile("([A-Z]-[A-Z]){1,}(-[A-Z])*");

    public int execute(Digraph digraph, String route) throws TownConnectionDoesNotExists, RouteInputFormatException {
        Matcher matcher = PATTERN.matcher(route);

        if(matcher.matches()) {
            int distance = 0;
            String[] towns = route.split("-");

            for (int i = 0; i < towns.length - 1; i++) {
                if (towns[i + 1] != null) {
                    Town from = new Town(towns[i]);
                    Town to = new Town(towns[i + 1]);

                    distance += digraph.distance(from, to);
                }
            }
            return distance;
        } else {
            throw new RouteInputFormatException("Formato da rota especificada errado.");
        }
    }

}
