package edu.umb.cs680.Hw10.fs;

import edu.umb.cs680.Hw10.fs.util.FileCrawlingVisitor;

import java.util.List;

public class FileCrawlingCommand implements FSCommand {
    private FileCrawlingVisitor visitor;
    private Directory rootDirs;

    public FileCrawlingCommand(FileCrawlingVisitor visitor, Directory rootDir) {
        this.visitor = visitor;
        this.rootDirs = rootDir;
    }

    @Override
    public void execute() {
        rootDirs.accept(visitor);
        List<File> allFiles = visitor.getFiles();
        for (File file : allFiles) {
            System.out.println("Crawled file: " + file.getName());
        }
    }}
