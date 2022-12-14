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

        final Day09_RopeBridge ropeBridge = new Day09_RopeBridge(1);
        commands.forEach(ropeBridge::processMoveCommand);
        final int numberOfUniqueTailPositions = ropeBridge.getNumberOfUniqueLastTailPositions();
        assertEquals(13, numberOfUniqueTailPositions);
    }

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> commands = this.getDataFromFileAsList("day09_data");
        final Day09_RopeBridge ropeBridge = new Day09_RopeBridge(1);
        commands.forEach(ropeBridge::processMoveCommand);
        final int numberOfUniqueTailPositions = ropeBridge.getNumberOfUniqueLastTailPositions();
        assertEquals(6311, numberOfUniqueTailPositions);
    }

    @Test
    public void task2SimpleTest1() {
        final List<String> commands = new ArrayList<>();
        commands.add("R 4");
        commands.add("U 4");
        commands.add("L 3");
        commands.add("D 1");
        commands.add("R 4");
        commands.add("D 1");
        commands.add("L 5");
        commands.add("R 2");

        final Day09_RopeBridge ropeBridge = new Day09_RopeBridge(9);
        commands.forEach(ropeBridge::processMoveCommand);
        final int numberOfUniqueTailPositions = ropeBridge.getNumberOfUniqueLastTailPositions();
        assertEquals(1, numberOfUniqueTailPositions);
    }

    @Test
    public void task2SimpleTest2() {
        final List<String> commands = new ArrayList<>();
        commands.add("R 5");
        commands.add("U 8");
        commands.add("L 8");
        commands.add("D 3");
        commands.add("R 17");
        commands.add("D 10");
        commands.add("L 25");
        commands.add("U 20");

        final Day09_RopeBridge ropeBridge = new Day09_RopeBridge(9);
        commands.forEach(ropeBridge::processMoveCommand);
        final int numberOfUniqueTailPositions = ropeBridge.getNumberOfUniqueLastTailPositions();
        assertEquals(36, numberOfUniqueTailPositions);
    }

    @Test
    public void task2Test() throws IOException, URISyntaxException {
        final List<String> commands = this.getDataFromFileAsList("day09_data");
        final Day09_RopeBridge ropeBridge = new Day09_RopeBridge(9);
        commands.forEach(ropeBridge::processMoveCommand);
        final int numberOfUniqueTailPositions = ropeBridge.getNumberOfUniqueLastTailPositions();
        assertEquals(2492, numberOfUniqueTailPositions);
        // 2492 -> too high...
        // https://www.reddit.com/r/adventofcode/comments/zgnice/2022_day_9_solutions/
        // while the head can never have a distance of +/-2,+/-2 to knot 1, this CAN happen for knot X to knot X + 1!
    }
}
