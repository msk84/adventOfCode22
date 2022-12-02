package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {

    @Test
    public void Task1Test() throws IOException, URISyntaxException {
        final List<String> data = this.getDay01DataAsList();
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

    private List<String> getDay01DataAsList() throws IOException, URISyntaxException {
        final Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("day01_data")).toURI());

        return Files.readAllLines(path);
    }
}
