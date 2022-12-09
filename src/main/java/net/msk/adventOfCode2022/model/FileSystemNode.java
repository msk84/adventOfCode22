package net.msk.adventOfCode2022.model;

public abstract class FileSystemNode {
    private final String name;

    public FileSystemNode(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getSize();
}
