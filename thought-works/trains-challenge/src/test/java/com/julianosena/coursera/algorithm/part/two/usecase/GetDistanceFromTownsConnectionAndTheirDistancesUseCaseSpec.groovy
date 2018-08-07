package com.julianosena.coursera.algorithm.part.two.usecase

import spock.lang.Specification

class GetDistanceFromTownsConnectionAndTheirDistancesUseCaseSpec extends Specification {

    GetDistanceFromTownsConnectionAndTheirDistancesUseCase getDistanceFromTownsConnectionAndTheirDistancesUseCase = new GetDistanceFromTownsConnectionAndTheirDistancesUseCase()

    def "Should return a distance from Towns Connection and their distances input"(){
        given : "right input"
        String input = "AB5"

        when : "this usecase is called with the right input"
        getDistanceFromTownsConnectionAndTheirDistancesUseCase.execute(input)

        then : "the distance town that connection should be returned"
        int distance = getDistanceFromTownsConnectionAndTheirDistancesUseCase.execute(input)

        and : "its name should be right"
        5 == distance
    }

}
