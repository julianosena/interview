package com.julianosena.coursera.algorithm.part.two.usecase;

import com.julianosena.coursera.algorithm.part.two.domain.Town;
import com.julianosena.coursera.algorithm.part.two.domain.exception.TownConnectionInputFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFirstTownFromTownsConnectionAndTheirDistancesUseCase {

    private final Pattern PATTERN = Pattern.compile("[A-Z]{2}[0-9]+");

    public Town execute(String connection) throws TownConnectionInputFormatException {
        Matcher matcher = PATTERN.matcher(connection);
        if(matcher.matches()){
            return new Town(connection.substring(0,1));

        } else {
            throw new TownConnectionInputFormatException("Wrong connection input format");
        }
    }

}
