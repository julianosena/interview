package com.julianosena.coursera.algorithm.part.two.usecase

import com.julianosena.coursera.algorithm.part.two.domain.Town
import spock.lang.Specification

class GetFirstTownFromTownsConnectionAndTheirDistancesUseCaseSpec extends Specification {

    GetFirstTownFromTownsConnectionAndTheirDistancesUseCase getFirstTownFromTownsConnectionAndTheirDistancesUseCase = new GetFirstTownFromTownsConnectionAndTheirDistancesUseCase()

    def "Should return a first Town instance from Towns Connection and their distances input"(){
        given : "right input"
        String input = "AB5"

        when : "this usecase is called with the right input"
        getFirstTownFromTownsConnectionAndTheirDistancesUseCase.execute(input)

        then : "the first town from that connection should be returned"
        Town town = getFirstTownFromTownsConnectionAndTheirDistancesUseCase.execute(input)

        and : "its name should be right"
        "A" == town.name()
    }

}
