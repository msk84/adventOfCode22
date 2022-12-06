package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test extends BaseTest {

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> data = this.getDataFromFileAsList("day01_data");
        final List<Integer> resultList = new ArrayList<>();
        int currentSum = 0;

        for(final String elem : data) {
            if(!elem.isEmpty()) {
                currentSum += Integer.parseInt(elem);
                continue;
            }
            resultList.add(currentSum);
            currentSum = 0;
        }
        resultList.add(currentSum);

        final int result = resultList.stream().max(Comparator.naturalOrder()).get();
        List<Integer> resultList2 = resultList.stream().sorted(Comparator.reverseOrder()).toList();

        final int result2 = resultList2.get(0) + resultList2.get(1) + resultList2.get(2);

        assertEquals(69281, result);
        assertEquals(201524, result2);
    }
}
