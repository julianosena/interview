package com.julianosena.coursera.algorithm.part.two.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Town implements Serializable {

    private static final long serialVersionUID = 5006029302104038595L;

    private final String name;
    private final Map<String, TownConnection> connections;

    public Town(String name) {
        this.name = name;
        this.connections = new HashMap<>();
    }

    public String name(){
        return this.name;
    }

    public Map<String, TownConnection> connections(){
        return this.connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town)) return false;
        Town town = (Town) o;
        return Objects.equals(name, town.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
