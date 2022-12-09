package net.msk.adventOfCode2022.model;

import java.io.BufferedReader;
import java.io.IOException;

public class FileSystem {

    private final Directory root;
    private Directory currentDirectory;

    private static int dirIsSmallerSum = 0;

    public FileSystem() {
        this.root = new Directory("/");
        this.currentDirectory = this.root;
    }

    public void processInput(final BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.startsWith("$ ")) {
                final String command = line.substring(2, 4);
                if(command.equals("cd")) {
                    this.processCd(line.substring(5));
                }
                else if(command.equals("ls")) {
                    processLs(reader);
                }
                else {
                    throw new IllegalArgumentException("Seems like something went wrong with this line ('" + line + "')...");
                }
            }
        }
    }

    public int getTotalSizeOfAllDirectoriesSmallerThan(final Integer sizeLimitToBeConsidered) {
        synchronized (FileSystem.class) {
            dirIsSmallerSum = 0;
            final int result = iterateDirectories(this.root, sizeLimitToBeConsidered);
            if(sizeLimitToBeConsidered != null) {
                return dirIsSmallerSum;
            }
            else {
                return result;
            }
        }
    }

    private static Integer iterateDirectories(final Directory dir, final Integer sizeLimitToBeConsidered) {
        int result = 0;
        for(final Directory subDir : dir.getAllChildDirectories()) {
            final Integer subDirSize = iterateDirectories(subDir, sizeLimitToBeConsidered);
            result += subDirSize;
        }

        result += dir.getSizeOfFiles();
        if(sizeLimitToBeConsidered == null || result < sizeLimitToBeConsidered){
            dirIsSmallerSum += result;
        }
        return result;
    }

    private void processCd(final String param) {
        if(param.equals("/")) { // navigate to root
            this.currentDirectory = this.root;
        }
        else if(param.equals("..")) { // go up one dir
            if(this.currentDirectory.getParent() != null) {
                this.currentDirectory = this.currentDirectory.getParent();
            }
            else {
                throw new IllegalArgumentException("This directory ('" + this.currentDirectory.getName() + "') has no parent. You must be in root already.");
            }
        }
        else { // go down one dir
            if(this.currentDirectory.hasChildDirectory(param)) {
                this.currentDirectory = this.currentDirectory.getChildDirectory(param);
            }
            else {
                throw new IllegalArgumentException("This directory has no child directory '" + param + "'.");
            }
        }
    }

    private void processLs(final BufferedReader reader) throws IOException {
        reader.mark(1000);
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.startsWith("$ ")) { // found the next command, go back
                reader.reset();
                return;
            }
            else {
                if(line.startsWith("dir ")) { // found a sub dir
                    this.currentDirectory.addChild(new Directory(line.substring(4), this.currentDirectory));
                }
                else {
                    final String[] fileData = line.split(" ");
                    this.currentDirectory.addChild(new File(fileData[1], Integer.parseInt(fileData[0])));
                }
            }
            reader.mark(1000);
        }
    }
}
