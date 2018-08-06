package com.julianosena.coursera.algorithm.part.two;

import com.julianosena.coursera.algorithm.part.two.domain.Digraph;
import com.julianosena.coursera.algorithm.part.two.domain.exception.RouteInputFormatException;
import com.julianosena.coursera.algorithm.part.two.domain.exception.TownConnectionDoesNotExists;
import com.julianosena.coursera.algorithm.part.two.domain.exception.TownConnectionInputFormatException;
import com.julianosena.coursera.algorithm.part.two.usecase.GetDigraphUseCase;
import com.julianosena.coursera.algorithm.part.two.usecase.GetDistanceFromRouteUseCase;

public class Main {

    public static void main(String...input) {
        try {
            Digraph digraph = new GetDigraphUseCase().execute(input);

            String test = "C-B";

            int distance = new GetDistanceFromRouteUseCase().execute(digraph, test);

        } catch (TownConnectionInputFormatException e) {

        } catch (TownConnectionDoesNotExists townConnectionDoesNotExists) {

        } catch (RouteInputFormatException e) {

        }
    }
}