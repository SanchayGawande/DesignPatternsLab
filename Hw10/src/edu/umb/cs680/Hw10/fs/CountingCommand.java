package edu.umb.cs680.Hw10.fs;

import edu.umb.cs680.Hw10.fs.util.CountingVisitor;

public class CountingCommand implements FSCommand {
    private CountingVisitor visitor;
    private Directory rootDirs;

    public CountingCommand(Directory dir) {
        this.visitor = new CountingVisitor();
        this.rootDirs = dir;
    }

    @Override
    public void execute() {
        rootDirs.accept(visitor);
        System.out.println("Total directories: " + visitor.getDirNum());
        System.out.println("Total files: " + visitor.getFileNum());
        System.out.println("Total links: " + visitor.getLinkNum());
    }

    public CountingVisitor getVisitor() {
        return this.visitor;
    }
}


