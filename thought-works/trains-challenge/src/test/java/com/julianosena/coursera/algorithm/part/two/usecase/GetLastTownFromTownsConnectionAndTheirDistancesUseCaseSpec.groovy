package com.julianosena.coursera.algorithm.part.two.usecase

import com.julianosena.coursera.algorithm.part.two.domain.Town
import spock.lang.Specification

class GetLastTownFromTownsConnectionAndTheirDistancesUseCaseSpec extends Specification {

    GetLastTownFromTownsConnectionAndTheirDistancesUseCase getLastTownFromTownsConnectionAndTheirDistancesUseCase = new GetLastTownFromTownsConnectionAndTheirDistancesUseCase()

    def "Should return a last Town instance from Towns Connection and their distances input"(){
        given : "right input"
        String input = "AB5"

        when : "this usecase is called with the right input"
        getLastTownFromTownsConnectionAndTheirDistancesUseCase.execute(input)

        then : "the last town from that connection should be returned"
        Town town = getLastTownFromTownsConnectionAndTheirDistancesUseCase.execute(input)

        and : "its name should be right"
        "B" == town.name()
    }

}
