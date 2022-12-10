package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.Forrest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day08Test extends BaseTest {

    @Test
    public void task1SimpleTest() {
        final List<String> testData = new ArrayList<>();
        testData.add("30373");
        testData.add("25512");
        testData.add("65332");
        testData.add("33549");
        testData.add("35390");

        final Forrest forrest = new Forrest(testData);
        assertEquals(21, forrest.getNumberOfVisibleTrees());
    }

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> data = this.getDataFromFileAsList("day08_data");
        final Forrest forrest = new Forrest(data);
        final long numberOfVisibleTrees = forrest.getNumberOfVisibleTrees();
        assertEquals(1647, numberOfVisibleTrees);
    }
}
