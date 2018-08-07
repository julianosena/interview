package com.julianosena.coursera.algorithm.part.two.usecase

import com.julianosena.coursera.algorithm.part.two.domain.Digraph
import com.julianosena.coursera.algorithm.part.two.domain.Town
import spock.lang.Specification

import static com.julianosena.coursera.algorithm.part.two.usecase.GetTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase.*

class GetTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCaseSpec extends Specification {

    GetTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase getTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase

    def "Should return 2 for the number of trips starting at C and ending at C with maximum 3 stops"(){
        given : "digraph"
        String[] data = ["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "filter parameters"
        Starts starts = new Starts(new Town("A"))
        Ending ending = new Ending(new Town("C"))
        StopsNumber stopsNumber = new StopsNumber(4)
        getTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase = new GetTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase.Builder()
                .digraph(digraph)
                .starts(starts)
                .ending(ending)
                .stopsNumber(stopsNumber)
                .build()

        when : "get amount trip by exactly stops amount is called"
        getTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase.execute()

        then : "the amount of trips that starts at A"
        and : "ending at C and"
        and : "stops is 4 should be 3"
        getTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase.execute() == 3
    }

    def "Should return 1 for number of trips starting at C and ending at C with maximum 3 stops"(){
        given : "digraph"
        String[] data = ["AB5", "BF4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7", "FC2"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "filter parameters"
        Starts starts = new Starts(new Town("A"))
        Ending ending = new Ending(new Town("C"))
        StopsNumber stopsNumber = new StopsNumber(3)
        getTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase = new GetTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase.Builder()
                .digraph(digraph)
                .starts(starts)
                .ending(ending)
                .stopsNumber(stopsNumber)
                .build()

        when : "get amount trip by exactly stops amount usecase is called"
        getTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase.execute()

        then : "the amount of trips that starts at A"
        and : "ending at C and"
        and : "maximum stops is 3 should be 2"
        getTripsAmountStartsInTownAndEndingAnotherTownExactlyStopsUseCase.execute() == 2
    }

}
