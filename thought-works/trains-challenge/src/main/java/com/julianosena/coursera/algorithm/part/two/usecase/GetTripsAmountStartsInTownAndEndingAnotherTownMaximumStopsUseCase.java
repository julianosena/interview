package com.julianosena.coursera.algorithm.part.two.usecase;

import com.julianosena.coursera.algorithm.part.two.domain.Digraph;
import com.julianosena.coursera.algorithm.part.two.domain.Town;
import com.julianosena.coursera.algorithm.part.two.domain.TownConnection;

import java.util.List;

public class GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase {

    private Digraph digraph;
    private Starts starts;
    private Ending ending;
    private MaximumStops maximumStops;

    public int execute(){
        List<TownConnection> fromConnections = digraph.towns().get(starts.town);
        return amount(fromConnections, ending, 0);
    }

    /**
     * Recursive function that iterate a linked list from digraph, start in starts town
     * and return trip amount that starts with Stars property value and ending with Ending property value
     * @param townConnections
     * @param ending
     * @return amount
     */
    private int amount(List<TownConnection> townConnections, Ending ending, int stop){
        int amount = 0;
        if(stop > maximumStops.limit) return amount;

        for(TownConnection townConnection : townConnections){
            if(townConnection.destiny().equals(ending.town)) {
                return ++amount;

            } else if (!digraph.towns().get(townConnection.destiny()).isEmpty()) {
                List<TownConnection> connections = digraph.towns().get(townConnection.destiny());
                amount += this.amount(connections, ending, ++stop);
            }
        }
        return amount;
    }

    public class Builder {

        private final GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase instance;

        public Builder() {
            this.instance = new GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase();
        }

        public Builder digraph(Digraph digraph){
            this.instance.digraph = digraph;
            return this;
        }

        public Builder starts(Starts starts){
            this.instance.starts = starts;
            return this;
        }

        public Builder ending(Ending ending){
            this.instance.ending = ending;
            return this;
        }

        public Builder maximumStops(MaximumStops maximumStops){
            this.instance.maximumStops = maximumStops;
            return this;
        }

        public GetTripsAmountStartsInTownAndEndingAnotherTownMaximumStopsUseCase build(){
            if(null == instance.digraph && null == instance.starts && null == instance.ending && null == instance.maximumStops) throw new IllegalStateException("Fill all properties");
            return this.instance;
        }
    }

    public static class Starts {
        private final Town town;

        public Starts(Town town){
            this.town = town;
        }

        public Town town(){
            return this.town;
        }
    }

    public static class Ending {
        private final Town town;

        public Ending(Town town){
            this.town = town;
        }

        public Town town(){
            return this.town;
        }
    }

    public static class MaximumStops {
        private final int limit;

        public MaximumStops(int limit){
            this.limit = limit;
        }

        public int limit(){
            return this.limit;
        }
    }
}
