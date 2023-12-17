package edu.umb.cs680.Hw09.fs.util;

import edu.umb.cs680.Hw09.fs.*;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files;

    public LinkedList<File> getFiles() {
        return files;
    }

    public FileCrawlingVisitor() {
        files = new LinkedList<File>();

    }

    @Override
    public void visit(Link link) {
        return;
    }
    @Override
    public void visit(Directory dir) {
        return;
    }
    @Override
    public void visit (File file) {
        files. add (file);
    }
}


