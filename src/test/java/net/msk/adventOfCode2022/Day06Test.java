package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day06Test extends BaseTest {

    @Test
    public void task1SimpleTest() throws IOException {
        assertEquals(7, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("mjqjpqmgbljsphdztnvjfqwrcgsmlb".getBytes()))));
        assertEquals(5, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("bvwbjplbgvbhsrlpgdmjqwftvncz".getBytes()))));
        assertEquals(6, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("nppdvjthqldpwncqszvftbrmjlhg".getBytes()))));
        assertEquals(10, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".getBytes()))));
        assertEquals(11, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".getBytes()))));
    }

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("day06_data")).toURI());
        final InputStream inputStream = new FileInputStream(path.toFile());
        final Reader reader = new InputStreamReader(inputStream);
        final int markerPosition = Day06_TuningTrouble.findEndOfMarkerPosition(reader);
        assertEquals(1802, markerPosition);
    }
}
