package edu.umb.cs680.Hw09.fs.util;
import edu.umb.cs680.Hw09.fs.File;
import edu.umb.cs680.Hw09.fs.FileSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.LinkedList;

public class FileCrawlingVisitorTest {

    private static FileSystem fs;
    private static FileCrawlingVisitor visitor;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
        visitor = new FileCrawlingVisitor();
        fs.getRootDirs().getFirst().accept(visitor);
    }

    @Test
    public void testFileCrawlingVisitor() {
        LinkedList<File> visitedFiles = visitor.getFiles();
        assertTrue(visitedFiles.stream().anyMatch(file -> file.getName().equals("A.java")), "Visited files should include A.java");
        assertTrue(visitedFiles.stream().anyMatch(file -> file.getName().equals("B.java")), "Visited files should include B.java");
        assertTrue(visitedFiles.stream().anyMatch(file -> file.getName().equals("ATest.java")), "Visited files should include A.java");
        assertTrue(visitedFiles.stream().anyMatch(file -> file.getName().equals("BTest.java")), "Visited files should include B.java");
        assertTrue(visitedFiles.stream().anyMatch(file -> file.getName().equals("readme.md")), "Visited files should include A.java");

    }
}