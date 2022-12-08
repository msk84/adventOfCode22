package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day06Test extends BaseTest {


    private static final int START_OF_PACKET_MARKER_LENGTH = 4;
    private static final int START_OF_MESSAGE_MARKER_LENGTH = 14;

    @Test
    public void task1SimpleTest() throws IOException {
        assertEquals(7, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("mjqjpqmgbljsphdztnvjfqwrcgsmlb".getBytes())), START_OF_PACKET_MARKER_LENGTH));
        assertEquals(5, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("bvwbjplbgvbhsrlpgdmjqwftvncz".getBytes())), START_OF_PACKET_MARKER_LENGTH));
        assertEquals(6, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("nppdvjthqldpwncqszvftbrmjlhg".getBytes())), START_OF_PACKET_MARKER_LENGTH));
        assertEquals(10, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".getBytes())), START_OF_PACKET_MARKER_LENGTH));
        assertEquals(11, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".getBytes())), START_OF_PACKET_MARKER_LENGTH));

        assertEquals(19, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("mjqjpqmgbljsphdztnvjfqwrcgsmlb".getBytes())), START_OF_MESSAGE_MARKER_LENGTH));
        assertEquals(23, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("bvwbjplbgvbhsrlpgdmjqwftvncz".getBytes())), START_OF_MESSAGE_MARKER_LENGTH));
        assertEquals(23, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("nppdvjthqldpwncqszvftbrmjlhg".getBytes())), START_OF_MESSAGE_MARKER_LENGTH));
        assertEquals(29, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".getBytes())), START_OF_MESSAGE_MARKER_LENGTH));
        assertEquals(26, Day06_TuningTrouble.findEndOfMarkerPosition(new InputStreamReader(new ByteArrayInputStream("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".getBytes())), START_OF_MESSAGE_MARKER_LENGTH));
    }

    @ParameterizedTest
    @ValueSource(ints = {START_OF_PACKET_MARKER_LENGTH, START_OF_MESSAGE_MARKER_LENGTH})
    public void task1AndTask2Test(final int markerLength) throws IOException, URISyntaxException {
        final Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("day06_data")).toURI());
        final InputStream inputStream = new FileInputStream(path.toFile());
        final Reader reader = new InputStreamReader(inputStream);
        final int markerPosition = Day06_TuningTrouble.findEndOfMarkerPosition(reader, markerLength);

        if(markerLength == START_OF_PACKET_MARKER_LENGTH) {
            assertEquals(1802, markerPosition);
        }
        else {
            assertEquals(3551, markerPosition);
        }
    }
}
