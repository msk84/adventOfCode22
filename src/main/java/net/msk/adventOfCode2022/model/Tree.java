package net.msk.adventOfCode2022.model;

public class Tree {
    private final int size;
    private boolean isVisible = false;
    private int scenicScore;

    public Tree(final int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setVisible() {
        this.isVisible = true;
    }

    public int getScenicScore() {
        return scenicScore;
    }

    public void setScenicScore(final int scenicScore) {
        this.scenicScore = scenicScore;
    }
}
