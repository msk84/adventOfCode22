package net.msk.adventOfCode2022;

import java.util.Set;
import java.util.stream.Collectors;

public class Day03_RucksackReorganization {

    public static int getItemPriority(final Character c) {
        if(Character.isLowerCase(c)) {
            return c - 96;
        }
        else {
            return c - 38;
        }
    }

    public static Character getDuplicateItem(final String items) {
        final Set<Character> set1 = items.substring(0, (items.length()/2)).chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        final Set<Character> set2 = items.substring((items.length()/2)).chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.iterator().next();
    }
}
