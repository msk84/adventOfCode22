package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.Pair;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day04_CampCleanup {

    public static long countFullyContainedSections(final List<String> inputData) {
        return inputData.stream()
                .filter(l -> sectionsFullyContainsTheOther(parseLine(l)))
                .count();
    }

    public static long countIntersectingSections(final List<String> inputData) {
        return inputData.stream()
                .filter(l -> sectionsOverlap(parseLine(l)))
                .count();
    }

    public static boolean sectionsFullyContainsTheOther(final Pair<Set<Integer>, Set<Integer>> sectionData) {
        return sectionData.key().containsAll(sectionData.value()) || sectionData.value().containsAll(sectionData.key());
    }

    public static boolean sectionsOverlap(final Pair<Set<Integer>, Set<Integer>> sectionData) {
        return !Collections.disjoint(sectionData.key(), sectionData.value());
    }

    public static Pair<Set<Integer>, Set<Integer>> parseLine(final String line) {
        final String[] rangeStrings = line.split(",");
        final Set<Integer> range1 = parseRange(rangeStrings[0]);
        final Set<Integer> range2 = parseRange(rangeStrings[1]);
        return Pair.of(range1, range2);
    }

    public static Set<Integer> parseRange(final String rangeString) {
        final String[] rangeEndValues = rangeString.split("-");
        return IntStream
                .rangeClosed(Integer.parseInt(rangeEndValues[0]), Integer.parseInt(rangeEndValues[1]))
                .boxed()
                .collect(Collectors.toSet());
    }
}
