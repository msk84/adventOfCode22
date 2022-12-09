package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.Pair;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static net.msk.adventOfCode2022.Day02_RockPaperScissors.*;
import static net.msk.adventOfCode2022.Day02_RockPaperScissors.GameResult.*;
import static net.msk.adventOfCode2022.Day02_RockPaperScissors.RockPaperScissors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test extends BaseTest {

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> lines = this.getDataFromFileAsList("day02_data");
        final List<Pair<RockPaperScissors, RockPaperScissors>> gameList = lines.stream()
                .map(l -> {
                    final String[] stringArray = l.split(" ");
                    return Pair.of(convertStringToRPS(stringArray[0]), convertStringToRPS(stringArray[1]));
                })
                .toList();

        assertEquals(12679, Day02_RockPaperScissors.calculateRPSGameListScore(gameList));
    }

    @Test
    public void task2Test() throws IOException, URISyntaxException {
        final List<String> lines = this.getDataFromFileAsList("day02_data");
        final List<Pair<RockPaperScissors, GameResult>> gameList = lines.stream()
                .map(l -> {
                    final String[] stringArray = l.split(" ");
                    return Pair.of(convertStringToRPS(stringArray[0]), convertStringToGameResult(stringArray[1]));
                })
                .toList();

        assertEquals(14470, Day02_RockPaperScissors.calculateRPSGameResultListScore(gameList));
    }

    private RockPaperScissors convertStringToRPS(final String stringValue) {
        return switch (stringValue) {
            case "A", "X" -> Rock;
            case "B", "Y" -> Paper;
            case "C", "Z" -> Scissors;
            default -> throw new IllegalArgumentException("Invalid RPS input value.");
        };
    }

    private GameResult convertStringToGameResult(final String stringValue) {
        return switch (stringValue) {
            case "X" -> LOST;
            case "Y" -> TIE;
            case "Z" -> WON;
            default -> throw new IllegalArgumentException("Invaliid GameResult input value.");
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
}
