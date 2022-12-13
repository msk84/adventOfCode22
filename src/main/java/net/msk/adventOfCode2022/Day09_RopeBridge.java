package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.Position;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;

public class Day09_RopeBridge {

    private Position currentHead = new Position(0,0);

    private Position currentTail = new Position(0,0);

    private final Set<Position> uniqueTailHistory = new HashSet<>();

    private enum Direction {
        U, D, L, R
    }

    public Day09_RopeBridge() {
        this.uniqueTailHistory.add(this.currentTail);
    }

    public void processMoveCommand(final String command) {
        final String[] commandValues = command.split(" ");
        final Direction dir = Direction.valueOf(commandValues[0]);
        final int steps = Integer.parseInt(commandValues[1]);

        this.moveHead(dir, steps);
    }

    public int getNumberOfUniqueTailPositions() {
        return this.uniqueTailHistory.size();
    }

    private void moveHead(final Direction dir, final int steps) {
        for (int i = 0; i < steps; i++) {
            this.stepHead(dir);
        }
    }

    private void stepHead(final Direction dir) {
        switch (dir) {
            case U -> this.currentHead = Position.of(this.currentHead.x(), this.currentHead.y() + 1);
            case D -> this.currentHead = Position.of(this.currentHead.x(), this.currentHead.y() - 1);
            case L -> this.currentHead = Position.of(this.currentHead.x() - 1, this.currentHead.y());
            case R -> this.currentHead = Position.of(this.currentHead.x() + 1, this.currentHead.y());
        }

        this.stepTail();
    }

    private void stepTail() {
        final int xAbsDiff = abs(this.currentHead.x() - this.currentTail.x());
        final int yAbsDiff = abs(this.currentHead.y() - this.currentTail.y());
        if(xAbsDiff > 1 || yAbsDiff > 1) {
            int newTailX = this.currentTail.x();
            int newTailY = this.currentTail.y();

            if(xAbsDiff > 1) {
                newTailX = this.currentTail.x() + ((this.currentHead.x() - this.currentTail.x()) / xAbsDiff);
                if(yAbsDiff > 0) {
                    newTailY = this.currentHead.y();
                }
            }
            else {
                newTailY = this.currentTail.y() + ((this.currentHead.y() - this.currentTail.y()) / yAbsDiff);
                if(xAbsDiff > 0) {
                    newTailX = this.currentHead.x();
                }
            }

            this.currentTail = Position.of(newTailX, newTailY);
            this.uniqueTailHistory.add(this.currentTail);
        }
    }
}
