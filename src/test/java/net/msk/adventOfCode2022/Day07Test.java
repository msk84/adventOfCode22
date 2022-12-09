package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.FileSystem;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day07Test extends BaseTest {

    @Test
    public void task1SimpleTest() throws IOException, URISyntaxException {
        final Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("day07_test_data")).toURI());
        final InputStream inputStream = new FileInputStream(path.toFile());
        final Reader reader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(reader);

        final FileSystem fileSystem = new FileSystem();
        fileSystem.processInput(bufferedReader);

        assertEquals(48381165, fileSystem.getTotalSizeOfAllDirectoriesSmallerThan(null));
        assertEquals(95437, fileSystem.getTotalSizeOfAllDirectoriesSmallerThan(100000));
    }

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("day07_data")).toURI());
        final InputStream inputStream = new FileInputStream(path.toFile());
        final Reader reader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(reader);

        final FileSystem fileSystem = new FileSystem();
        fileSystem.processInput(bufferedReader);
        final int resultSum = fileSystem.getTotalSizeOfAllDirectoriesSmallerThan(100000);
        assertEquals(1297159, resultSum);
    }
}
