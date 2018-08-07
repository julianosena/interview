package com.julianosena.coursera.algorithm.part.two.usecase

import com.julianosena.coursera.algorithm.part.two.domain.Digraph
import com.julianosena.coursera.algorithm.part.two.domain.Town
import spock.lang.Specification

class GetDigraphUseCaseSpec extends Specification {

    GetDigraphUseCase getDigraphUseCase = new GetDigraphUseCase()

    def "Should parse and return Digraph from towns connections and their distances input"(){
        given : "the right input data"
        String[] input = ["AB2", "BC8", "DE1", "AE9", "BE8"]

        when: "this usecase is called"
        getDigraphUseCase.execute(input)

        then : "the digraph should be returned"
        Digraph digraph = getDigraphUseCase.execute(input)

        and : "with all 5 towns"
        digraph.TOWNS.size() == 5

        and : "all righ cities"
        input.each {
            null != digraph.TOWNS.get(it)
        }

        and : "and A town connections"
        Town a = new Town("A")
        digraph.TOWNS.get(a).first().destiny().name() == "B"
        digraph.TOWNS.get(a).last().destiny().name() == "E"

        digraph.TOWNS.get(a).size() == 2

        and : "and B town connections"
        Town b = new Town("B")

        digraph.TOWNS.get(b).first().destiny().name() == "C"
        digraph.TOWNS.get(b).last().destiny().name() == "E"
        digraph.TOWNS.get(b).size() == 2

        and : "and C town connections"
        Town c = new Town("C")
        digraph.TOWNS.get(c).size() == 0

        and : "and D town connections"
        Town d = new Town("D")

        digraph.TOWNS.get(d).first().destiny().name() == "E"
        digraph.TOWNS.get(d).size() == 1

        and : "and E town connections"
        Town e = new Town("E")

        digraph.TOWNS.get(e).size() == 0
    }

}
