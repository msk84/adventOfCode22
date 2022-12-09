package net.msk.adventOfCode2022.model;

import java.util.*;

public class Directory extends FileSystemNode {

    private Directory parent;

    private final Map<String, FileSystemNode> children = new HashMap<>();

    public Directory(final String name) {
        super(name);
    }

    public Directory(final String name, final Directory parent) {
        this(name);
        this.parent = parent;
    }

    public void addChild(FileSystemNode child) {
        this.children.put(child.getName(), child);
    }

    public boolean hasChildDirectory(final String name) {
        return this.children.containsKey(name) && this.children.get(name) instanceof Directory;
    }

    public Directory getChildDirectory(final String name) {
        if(this.hasChildDirectory(name)) {
            return (Directory) this.children.get(name);
        }
        else {
            throw new NoSuchElementException("Directory '" + name + "' not found in '" + this.getName() + "'.");
        }
    }

    public List<Directory> getAllChildDirectories() {
        return this.children.values().stream()
                .filter(d -> d instanceof Directory)
                .map(d -> (Directory)d)
                .toList();
    }

    public Directory getParent() {
        return this.parent;
    }

    public int getSize() {
        return this.children.values().stream()
                .mapToInt(FileSystemNode::getSize)
                .sum();
    }

    public int getSizeOfFiles() {
        return this.children.values().stream()
                .filter(n -> n instanceof File)
                .mapToInt(FileSystemNode::getSize)
                .sum();
    }
}
