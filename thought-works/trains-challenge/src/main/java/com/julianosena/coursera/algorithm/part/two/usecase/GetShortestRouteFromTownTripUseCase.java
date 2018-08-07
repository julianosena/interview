package com.julianosena.coursera.algorithm.part.two.usecase;

import com.julianosena.coursera.algorithm.part.two.domain.Digraph;
import com.julianosena.coursera.algorithm.part.two.domain.Route;
import com.julianosena.coursera.algorithm.part.two.domain.Town;
import com.julianosena.coursera.algorithm.part.two.domain.TownConnection;

import java.util.List;
import java.util.SortedSet;

public class GetShortestRouteFromTownTripUseCase {

    private Digraph digraph;
    private Starts starts;
    private Ending ending;

    public Route execute(){
        List<TownConnection> fromConnections = digraph.towns().get(starts.town);
        SortedSet<Route> routes = null;
        route(fromConnections, ending);
        return routes.first();
    }

    private Route route(List<TownConnection> townConnections, Ending ending){
        Route route = new Route();

        for(TownConnection townConnection : townConnections){
            route.addTown(townConnection.destiny(), townConnection.distance());

            if(townConnection.destiny().equals(ending.town)) {
                return route;

            } else if (!digraph.towns().get(townConnection.destiny()).isEmpty()) {
                List<TownConnection> connections = digraph.towns().get(townConnection.destiny());

            }
        }
        return route;
    }

    public class Builder {

        private final GetShortestRouteFromTownTripUseCase instance;

        public Builder() {
            this.instance = new GetShortestRouteFromTownTripUseCase();
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

        public GetShortestRouteFromTownTripUseCase build(){
            if(null == instance.digraph && null == instance.starts && null == instance.ending) throw new IllegalStateException("Fill all properties");
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
