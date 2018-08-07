package com.julianosena.coursera.algorithm.part.two.usecase

import com.julianosena.coursera.algorithm.part.two.domain.Digraph
import com.julianosena.coursera.algorithm.part.two.domain.exception.TownConnectionDoesNotExists
import spock.lang.Specification

class GetDistanceFromRouteUseCaseSpec extends Specification {

    GetDistanceFromRouteUseCase getDistanceFromRouteUseCase = new GetDistanceFromRouteUseCase()

    def "Should return a right distance from A-B-C route"(){
        given : "digraph"
        String[] data = ["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "route"
        String route = "A-B-C"

        when : "get distance town route usecase is called"
        getDistanceFromRouteUseCase.execute(digraph, route)

        then : "The distance should be 9"
        getDistanceFromRouteUseCase.execute(digraph, route) == 9
    }

    def "Should return a right distance from A-D route"(){
        given : "digraph"
        String[] data = ["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "route"
        String route = "A-D"

        when : "get distance town route usecase is called"
        getDistanceFromRouteUseCase.execute(digraph, route)

        then : "The distance should be 9"
        getDistanceFromRouteUseCase.execute(digraph, route) == 5
    }

    def "Should return a right distance from A-D-C route"(){
        given : "digraph"
        String[] data = ["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "route"
        String route = "A-D-C"

        when : "get distance town route usecase is called"
        getDistanceFromRouteUseCase.execute(digraph, route)

        then : "The distance should be 9"
        getDistanceFromRouteUseCase.execute(digraph, route) == 13
    }

    def "Should return a right distance from A-E-B-C-D route"(){
        given : "digraph"
        String[] data = ["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "route"
        String route = "A-E-B-C-D"

        when : "get distance town route usecase is called"
        getDistanceFromRouteUseCase.execute(digraph, route)

        then : "The distance should be 9"
        getDistanceFromRouteUseCase.execute(digraph, route) == 22
    }

    def "Should return a right distance from A-E-D route"(){
        given : "digraph"
        String[] data = ["AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"]
        Digraph digraph = new GetDigraphUseCase().execute(data)

        and : "route"
        String route = "A-E-D"

        when : "get distance town route usecase is called"
        getDistanceFromRouteUseCase.execute(digraph, route)

        then :
        thrown(TownConnectionDoesNotExists)
    }
}