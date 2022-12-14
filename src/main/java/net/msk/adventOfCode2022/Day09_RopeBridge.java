package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.Position;
import net.msk.adventOfCode2022.model.Knot;

import static java.lang.Integer.compare;
import static java.lang.Math.abs;

public class Day09_RopeBridge {

    private final Knot head;

    private enum Direction {
        U, D, L, R
    }

    public Day09_RopeBridge(final int numberOfTails) {
        final Position startPosition = new Position(0,0);
        Knot recentTail = new Knot(startPosition, null);
        for(int i=0; i<numberOfTails-1; i++) {
            recentTail = new Knot(startPosition, recentTail);
        }
        this.head = new Knot(startPosition, recentTail);
    }

    public void processMoveCommand(final String command) {
        final String[] commandValues = command.split(" ");
        final Direction dir = Direction.valueOf(commandValues[0]);
        final int steps = Integer.parseInt(commandValues[1]);
        this.moveHead(dir, steps);
    }

    public int getNumberOfUniqueLastTailPositions() {
        Knot currentKnot = this.head;
        while(currentKnot.hasNextKnot()) {
            currentKnot = currentKnot.getNextKnot();
        }
        return currentKnot.getUniquePositionHistory().size();
    }

    private void moveHead(final Direction dir, final int steps) {
        for (int i = 0; i < steps; i++) {
            this.stepHead(dir);
        }
    }

    private void stepHead(final Direction dir) {
        switch (dir) {
            case U -> this.head.setPosition(Position.of(this.head.getPosition().x(), this.head.getPosition().y() + 1));
            case D -> this.head.setPosition(Position.of(this.head.getPosition().x(), this.head.getPosition().y() - 1));
            case L -> this.head.setPosition(Position.of(this.head.getPosition().x() - 1, this.head.getPosition().y()));
            case R -> this.head.setPosition(Position.of(this.head.getPosition().x() + 1, this.head.getPosition().y()));
        }

        Knot currentKnot = this.head;
        while(currentKnot.hasNextKnot()) {
            this.stepTail(currentKnot, currentKnot.getNextKnot());
            currentKnot = currentKnot.getNextKnot();
        }
    }

    private void stepTail(final Knot leadingKnot, final Knot trailingKnot) {
        final int xDiff = leadingKnot.getPosition().x() - trailingKnot.getPosition().x();
        final int yDiff = leadingKnot.getPosition().y() - trailingKnot.getPosition().y();
        if(abs(xDiff) > 1 || abs(yDiff) > 1) {
            int newTailX = trailingKnot.getPosition().x() + compare(xDiff, 0);
            int newTailY = trailingKnot.getPosition().y() + compare(yDiff, 0);
            trailingKnot.setPosition(Position.of(newTailX, newTailY));
        }
    }
}
