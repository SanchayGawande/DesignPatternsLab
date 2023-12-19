package edu.umb.cs680.Hw15.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comp) {
        LinkedList<FSElement> sortedChildren = getChildren();
        Collections.sort(sortedChildren, comp);
        return sortedChildren;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.parent = this;
    }
    public int countChildren() {
        return children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirectories = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof Directory) {
                subDirectories.add((Directory) element);
            }
        }
        return subDirectories;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comp) {
        LinkedList<Directory> sortedSubDirs = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof Directory) {
                sortedSubDirs.add((Directory) element);
            }
        }
        Collections.sort(sortedSubDirs, comp);
        return sortedSubDirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof File) {
                files.add((File) element);
            }
        }
        return files;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comp) {
        LinkedList<File> sortedFiles = new LinkedList<>();
        for (FSElement element : children) {
            if (element instanceof File) {
                sortedFiles.add((File) element);
            }
        }
        Collections.sort(sortedFiles, comp);
        return sortedFiles;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement element : children) {
            if (element instanceof Directory) {
                totalSize += ((Directory) element).getTotalSize();
            } else {
                totalSize += element.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

}
