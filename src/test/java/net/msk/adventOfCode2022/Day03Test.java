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
                .mapToInt(l -> Day03_RucksackReorganization.getItemPriority(Day03_RucksackReorganization.findCommonItem(l)))
                .sum();

        assertEquals(7795, result);
    }

    @Test
    public void task2Test() throws IOException, URISyntaxException {
        final List<String> lines = this.getDataFromFileAsList("day03_data");
        int sum = 0;

        for(int i = 0; i < lines.size(); i=i+3) {
            final String line1 = lines.get(i);
            final String line2 = lines.get(i+1);
            final String line3 = lines.get(i+2);

            Character commonChar = Day03_RucksackReorganization.findCommonItem(line1, line2, line3);
            sum += Day03_RucksackReorganization.getItemPriority(commonChar);
        }

        assertEquals(2703, sum);
    }
}
