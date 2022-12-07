package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test extends BaseTest {
    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> lines = this.getDataFromFileAsList("day04_data");
        final long fullyContainedSectionsCount = Day04_CampCleanup.countFullyContainedSections(lines);

        assertEquals(513, fullyContainedSectionsCount);
    }
}
