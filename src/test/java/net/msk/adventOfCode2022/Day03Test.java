package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test extends BaseTest {
    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> lines = this.getDataFromFileAsList("day03_data");
        final int result = lines.stream()
                .mapToInt(l -> Day03_RucksackReorganization.getItemPriority(Day03_RucksackReorganization.getDuplicateItem(l)))
                .sum();

        assertEquals(7795, result);
    }
}
