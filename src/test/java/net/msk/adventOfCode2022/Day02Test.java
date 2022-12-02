package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static net.msk.adventOfCode2022.Day02_RockPaperScissors.*;
import static net.msk.adventOfCode2022.Day02_RockPaperScissors.RockPaperScissors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {

    @Test
    public void Task1Test() throws IOException, URISyntaxException {
        final List<String> lines = this.getDay02DataAsList();
        final List<Pair<RockPaperScissors, RockPaperScissors>> gameList = lines.stream()
                .map(l -> {
                    final String[] stringArray = l.split(" ");
                    return Pair.of(convertStringToRPS(stringArray[0]), convertStringToRPS(stringArray[1]));
                })
                .toList();

        assertEquals(12679, Day02_RockPaperScissors.calculateRPSGameListScore(gameList));
    }

    private RockPaperScissors convertStringToRPS(final String stringValue) {
        return switch (stringValue) {
            case "A", "X" -> Rock;
            case "B", "Y" -> Paper;
            case "C", "Z" -> Scissors;
            default -> throw new IllegalArgumentException("Invalid RPS input value.");
        };
    }

    @Test
    public void testCalculateRPSGameListScore() {
        final List<Pair<RockPaperScissors, RockPaperScissors>> gameList = new ArrayList<>();
        gameList.add(Pair.of(Rock, Paper));
        gameList.add(Pair.of(Paper, Rock));
        gameList.add(Pair.of(Scissors, Scissors));
        assertEquals(15, Day02_RockPaperScissors.calculateRPSGameListScore(gameList));
    }

    @Test
    public void testCalculateRPSScore() {
        assertEquals(8, Day02_RockPaperScissors.calculateRPSScore(Rock, Paper));
        assertEquals(1, Day02_RockPaperScissors.calculateRPSScore(Paper, Rock));
        assertEquals(6, Day02_RockPaperScissors.calculateRPSScore(Scissors, Scissors));
    }

    private List<String> getDay02DataAsList() throws IOException, URISyntaxException {
        final Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("day02_data")).toURI());

        return Files.readAllLines(path);
    }
}
