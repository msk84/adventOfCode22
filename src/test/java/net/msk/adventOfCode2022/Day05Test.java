package net.msk.adventOfCode2022;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day05Test extends BaseTest {

    @Test
    public void task1SimpleTest() {
        final List<String> lines = new ArrayList<>();
        lines.add("move 1 from 2 to 1");
        lines.add("move 3 from 1 to 3");
        lines.add("move 2 from 2 to 1");
        lines.add("move 1 from 1 to 2");

        final Day05_ContainerTerminal terminal = new Day05_ContainerTerminal();
        terminal.addStack(this.createStack(List.of('Z', 'N')));
        terminal.addStack(this.createStack(List.of('M', 'C', 'D')));
        terminal.addStack(this.createStack(List.of('P')));

        lines.forEach(l -> {
            final String[] splitString = l.split(" ");
            terminal.moveContainersOneByOne(Integer.parseInt(splitString[1]), Integer.parseInt(splitString[3]), Integer.parseInt(splitString[5]));
        });

        final List<Character> topLine = terminal.getTopLine();
        assertEquals('C', topLine.get(0));
        assertEquals('M', topLine.get(1));
        assertEquals('Z', topLine.get(2));
    }

    @Test
    public void task1Test() throws IOException, URISyntaxException {
        final List<String> lines = this.getDataFromFileAsList("day05_data");

        final Day05_ContainerTerminal terminal = new Day05_ContainerTerminal();
        terminal.addStack(this.createStack(List.of('B', 'L', 'D', 'T', 'W', 'C', 'F', 'M')));
        terminal.addStack(this.createStack(List.of('N', 'B', 'L')));
        terminal.addStack(this.createStack(List.of('J', 'C', 'H', 'T', 'L', 'V')));
        terminal.addStack(this.createStack(List.of('S', 'P', 'J', 'W')));
        terminal.addStack(this.createStack(List.of('Z', 'S', 'C', 'F', 'T', 'L', 'R')));
        terminal.addStack(this.createStack(List.of('W', 'D', 'G', 'B', 'H', 'N', 'Z')));
        terminal.addStack(this.createStack(List.of('F', 'M', 'S', 'P', 'V', 'G', 'C', 'N')));
        terminal.addStack(this.createStack(List.of('W', 'Q', 'R', 'J', 'F', 'V', 'C', 'Z')));
        terminal.addStack(this.createStack(List.of('R', 'P', 'M', 'L', 'H')));

        lines.forEach(l -> {
            final String[] splitString = l.split(" ");
            terminal.moveContainersOneByOne(Integer.parseInt(splitString[1]), Integer.parseInt(splitString[3]), Integer.parseInt(splitString[5]));
        });

        final List<Character> topLine = terminal.getTopLine();
        assertEquals('T', topLine.get(0));
        assertEquals('G', topLine.get(1));
        assertEquals('W', topLine.get(2));
        assertEquals('S', topLine.get(3));
        assertEquals('M', topLine.get(4));
        assertEquals('R', topLine.get(5));
        assertEquals('B', topLine.get(6));
        assertEquals('P', topLine.get(7));
        assertEquals('N', topLine.get(8));
    }

    private Stack<Character> createStack(final List<Character> charList) {
        final Stack<Character> stack = new Stack<>();
        charList.forEach(stack::push);
        return stack;
    }


    @Test
    public void task2SimpleTest() {
        final List<String> lines = new ArrayList<>();
        lines.add("move 1 from 2 to 1");
        lines.add("move 3 from 1 to 3");
        lines.add("move 2 from 2 to 1");
        lines.add("move 1 from 1 to 2");

        final Day05_ContainerTerminal terminal = new Day05_ContainerTerminal();
        terminal.addStack(this.createStack(List.of('Z', 'N')));
        terminal.addStack(this.createStack(List.of('M', 'C', 'D')));
        terminal.addStack(this.createStack(List.of('P')));

        lines.forEach(l -> {
            final String[] splitString = l.split(" ");
            terminal.moveContainersMultiple(Integer.parseInt(splitString[1]), Integer.parseInt(splitString[3]), Integer.parseInt(splitString[5]));
        });

        final List<Character> topLine = terminal.getTopLine();
        assertEquals('M', topLine.get(0));
        assertEquals('C', topLine.get(1));
        assertEquals('D', topLine.get(2));
    }

    @Test
    public void task2Test() throws IOException, URISyntaxException {
        final List<String> lines = this.getDataFromFileAsList("day05_data");

        final Day05_ContainerTerminal terminal = new Day05_ContainerTerminal();
        terminal.addStack(this.createStack(List.of('B', 'L', 'D', 'T', 'W', 'C', 'F', 'M')));
        terminal.addStack(this.createStack(List.of('N', 'B', 'L')));
        terminal.addStack(this.createStack(List.of('J', 'C', 'H', 'T', 'L', 'V')));
        terminal.addStack(this.createStack(List.of('S', 'P', 'J', 'W')));
        terminal.addStack(this.createStack(List.of('Z', 'S', 'C', 'F', 'T', 'L', 'R')));
        terminal.addStack(this.createStack(List.of('W', 'D', 'G', 'B', 'H', 'N', 'Z')));
        terminal.addStack(this.createStack(List.of('F', 'M', 'S', 'P', 'V', 'G', 'C', 'N')));
        terminal.addStack(this.createStack(List.of('W', 'Q', 'R', 'J', 'F', 'V', 'C', 'Z')));
        terminal.addStack(this.createStack(List.of('R', 'P', 'M', 'L', 'H')));

        lines.forEach(l -> {
            final String[] splitString = l.split(" ");
            terminal.moveContainersMultiple(Integer.parseInt(splitString[1]), Integer.parseInt(splitString[3]), Integer.parseInt(splitString[5]));
        });

        final List<Character> topLine = terminal.getTopLine();
        assertEquals('T', topLine.get(0));
        assertEquals('Z', topLine.get(1));
        assertEquals('L', topLine.get(2));
        assertEquals('T', topLine.get(3));
        assertEquals('L', topLine.get(4));
        assertEquals('W', topLine.get(5));
        assertEquals('R', topLine.get(6));
        assertEquals('N', topLine.get(7));
        assertEquals('F', topLine.get(8));
    }
}
