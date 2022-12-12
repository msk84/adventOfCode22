package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.Tree;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day08Test extends BaseTest {

    @Test
    public void task1SimpleTest() {
        final Day08_Forrest forrest = new Day08_Forrest(getSimpleTestData());
        assertEquals(21, forrest.getNumberOfVisibleTrees());
    }

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> data = this.getDataFromFileAsList("day08_data");
        final Day08_Forrest forrest = new Day08_Forrest(data);
        final long numberOfVisibleTrees = forrest.getNumberOfVisibleTrees();
        assertEquals(1647, numberOfVisibleTrees);
    }

    @Test
    public void task2SimpleTest() {
        final Day08_Forrest forrest = new Day08_Forrest(getSimpleTestData());
        forrest.getMaxScenicScore(); // just to trigger calculation
        final Tree tree1 = forrest.getTreeByCoordinate(2, 1);
        assertEquals(4, tree1.getScenicScore());
        final Tree tree2 = forrest.getTreeByCoordinate(2, 3);
        assertEquals(8, tree2.getScenicScore());
    }

    @Test
    public void task2Test() throws IOException, URISyntaxException {
        final List<String> data = this.getDataFromFileAsList("day08_data");
        final Day08_Forrest forrest = new Day08_Forrest(data);
        final int maxScenicScore = forrest.getMaxScenicScore();
        assertEquals(392080, maxScenicScore);
    }

    private List<String> getSimpleTestData() {
        final List<String> testData = new ArrayList<>();
        testData.add("30373");
        testData.add("25512");
        testData.add("65332");
        testData.add("33549");
        testData.add("35390");
        return testData;
    }
}
