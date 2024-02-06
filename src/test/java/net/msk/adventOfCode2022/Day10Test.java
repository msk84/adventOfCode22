package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Test extends BaseTest {

    @Test
    public void task1SimpleTest() {
    }

    @Test
    @Disabled
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> commands = this.getDataFromFileAsList("day10_data");
        final Day09_RopeBridge ropeBridge = new Day09_RopeBridge(1);
        commands.forEach(ropeBridge::processMoveCommand);
        final int numberOfUniqueTailPositions = ropeBridge.getNumberOfUniqueLastTailPositions();
        assertEquals(6311, numberOfUniqueTailPositions);
    }
}
