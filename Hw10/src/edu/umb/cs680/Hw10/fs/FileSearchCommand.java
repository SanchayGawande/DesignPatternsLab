package edu.umb.cs680.Hw10.fs;

import edu.umb.cs680.Hw10.fs.util.FileSearchVisitor;

import java.util.List;

public class FileSearchCommand implements FSCommand{
    private FileSearchVisitor visitor;
    private Directory rootDirs;

    public FileSearchCommand(FileSearchVisitor visitor, Directory dir) {
        this.visitor = visitor;
        this.rootDirs = dir;
    }

    @Override
    public void execute() {
        rootDirs.accept(visitor);
        List<File> foundFiles = visitor.getFoundFiles();
        if(foundFiles.isEmpty()) {
            System.out.println("No files found matching the criteria.");
        } else {
            for (File file : foundFiles) {
                System.out.println("Found file: " + file.getName());
            }
        }

    }
}
