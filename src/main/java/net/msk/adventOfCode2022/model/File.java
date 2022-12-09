package net.msk.adventOfCode2022.model;

public class File extends FileSystemNode {

    private final int size;

    public File(final String name, final int size) {
        super(name);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
