package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day09Test extends BaseTest {

    @Test
    public void task1SimpleTest() {
        final List<String> commands = new ArrayList<>();
        commands.add("R 4");
        commands.add("U 4");
        commands.add("L 3");
        commands.add("D 1");
        commands.add("R 4");
        commands.add("D 1");
        commands.add("L 5");
        commands.add("R 2");

        final Day09_RopeBridge ropeBridge = new Day09_RopeBridge();
        commands.forEach(ropeBridge::processMoveCommand);
        final int numberOfUniqueTailPositions = ropeBridge.getNumberOfUniqueTailPositions();
        assertEquals(13, numberOfUniqueTailPositions);
    }

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> commands = this.getDataFromFileAsList("day09_data");
        final Day09_RopeBridge ropeBridge = new Day09_RopeBridge();
        commands.forEach(ropeBridge::processMoveCommand);
        final int numberOfUniqueTailPositions = ropeBridge.getNumberOfUniqueTailPositions();
        assertEquals(6311, numberOfUniqueTailPositions);
    }
}
