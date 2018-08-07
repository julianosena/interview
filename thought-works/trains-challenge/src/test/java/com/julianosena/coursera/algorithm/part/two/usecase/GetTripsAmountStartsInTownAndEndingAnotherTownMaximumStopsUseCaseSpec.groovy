package com.julianosena.coursera.algorithm.part.two.usecase

import com.julianosena.coursera.algorithm.part.two.domain.Digraph
import com.julianosena.coursera.algorithm.part.two.domain.Town
import spock.lang.Specification

import static com.julianosena.coursera.algorithm.part.two.usecase.GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase.*

class GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCaseSpec extends Specification {

    GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase getTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase

    def "Should return 2 for the number of trips starting at C and ending at C with maximum 3 stops"(){
        given : "digraph"
        String[] data = ["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "filter parameters"
        Starts starts = new Starts(new Town("C"))
        Ending ending = new Ending(new Town("C"))
        MaximumStops maximumStops = new MaximumStops(3)
        getTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase = new GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase.Builder()
                .digraph(digraph)
                .starts(starts)
                .ending(ending)
                .maximumStops(maximumStops)
                .build()

        when : "get amount trip by maximum stops amount usecase is called"
        getTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase.execute()

        then : "the amount of trips that starts at C"
        and : "ending at C and"
        and : "maximum stops is 3 should be 2"
        getTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase.execute() == 2
    }

    def "Should return 1 for number of trips starting at C and ending at C with maximum 3 stops"(){
        given : "digraph"
        String[] data = ["AB5", "BF4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7", "FC2"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "filter parameters"
        Starts starts = new Starts(new Town("C"))
        Ending ending = new Ending(new Town("C"))
        MaximumStops maximumStops = new MaximumStops(3)
        getTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase = new GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase.Builder()
                .digraph(digraph)
                .starts(starts)
                .ending(ending)
                .maximumStops(maximumStops)
                .build()

        when : "get amount trip by maximum stops amount usecase is called"
        getTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase.execute()

        then : "the amount of trips that starts at C"
        and : "ending at C and"
        and : "maximum stops is 3 should be 1"
        getTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase.execute() == 1
    }

}
