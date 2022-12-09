package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.LimitedQueue;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.LinkedList;

public class Day06_TuningTrouble {

    public static int findEndOfMarkerPosition(final Reader streamReader, final int markerLength) throws IOException {
        final LinkedList<Character> charBuffer = new LimitedQueue<>(markerLength);
        int i = 1;
        int s;
        while((s = streamReader.read()) != -1) {
            final Character c = (char)s;
            charBuffer.add(c);
            if(isMarkerFound(charBuffer, markerLength)) {
                return i;
            }
            i++;
        }
        throw new RuntimeException("No marker found.");
    }

    private static boolean isMarkerFound(final LinkedList<Character> charBuffer, final int markerLength) {
        return new HashSet<>(charBuffer).size() == markerLength;
    }
}
