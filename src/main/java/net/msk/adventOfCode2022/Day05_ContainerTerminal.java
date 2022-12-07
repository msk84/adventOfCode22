package net.msk.adventOfCode2022;

import java.util.*;

public class Day05_ContainerTerminal {

    private final List<Stack<Character>> containerTerminal = new ArrayList<>();

    public void addStack(final Stack<Character> stack) {
        this.containerTerminal.add(stack);
    }

    public void moveContainersOneByOne(final int amount, final int from, final int to) {
        for(int i = 0; i < amount; i++) {
            final Stack<Character> fromStack = this.containerTerminal.get(from - 1);
            final Stack<Character> toStack = this.containerTerminal.get(to - 1);
            final Character container = fromStack.pop();
            toStack.push(container);
        }
    }

    public void moveContainersMultiple(final int amount, final int from, final int to) {
        final List<Character> movingContainers = new ArrayList<>();
        final Stack<Character> fromStack = this.containerTerminal.get(from - 1);
        final Stack<Character> toStack = this.containerTerminal.get(to - 1);

        for(int i = 0; i < amount; i++) {
            movingContainers.add(fromStack.pop());
        }
        Collections.reverse(movingContainers);
        movingContainers.forEach(toStack::push);
    }

    public List<Character> getTopLine() {
        return this.containerTerminal.stream()
                .map(Stack::peek)
                .toList();
    }
}
