package net.msk.adventOfCode2022.model;

import java.util.HashSet;
import java.util.Set;

public class Knot {

    private Position position;
    private final Knot nextKnot;
    private final Set<Position> uniquePositionHistory = new HashSet<>();

    public Knot(final Position position, final Knot nextKnot) {
        this.position = position;
        this.nextKnot = nextKnot;
        this.uniquePositionHistory.add(this.position);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.uniquePositionHistory.add(this.position);
    }

    public boolean hasNextKnot() {
        return this.nextKnot != null;
    }

    public Knot getNextKnot() {
        return this.nextKnot;
    }

    public Set<Position> getUniquePositionHistory() {
        return this.uniquePositionHistory;
    }
}
