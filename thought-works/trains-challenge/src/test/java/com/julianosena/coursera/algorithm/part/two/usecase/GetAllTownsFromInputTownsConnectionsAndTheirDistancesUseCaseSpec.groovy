package com.julianosena.coursera.algorithm.part.two.usecase

import com.julianosena.coursera.algorithm.part.two.domain.Town
import spock.lang.Specification

class GetAllTownsFromInputTownsConnectionsAndTheirDistancesUseCaseSpec extends Specification {

    GetAllTownsFromInputTownsConnectionsAndTheirDistancesUseCase getAllTownsFromInputTownsConnectionsAndTheirDistancesUseCase = new GetAllTownsFromInputTownsConnectionsAndTheirDistancesUseCase()

    def "Should parse and return towns connection and their distances input"(){
        given : "the right input data"
        String[] input = ["AB2", "BC8", "DE1", "AE9", "BE8"]

        when: "this usecase is called"
        getAllTownsFromInputTownsConnectionsAndTheirDistancesUseCase.execute(input)

        then : "the set of unique towns should be returned"
        Set<Town> towns = getAllTownsFromInputTownsConnectionsAndTheirDistancesUseCase.execute(input)
        null != towns

        and : "the size of this set should be 5"
        towns.size() == 5
    }

}
