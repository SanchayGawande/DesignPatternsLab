package edu.umb.cs680.Hw09.fs;

public interface FSVisitor {
    void visit(Directory dir);
    void visit(File file);
    void visit(Link link);
}
