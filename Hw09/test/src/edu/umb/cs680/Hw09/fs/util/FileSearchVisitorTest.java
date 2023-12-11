package edu.umb.cs680.Hw09.fs.util;

import edu.umb.cs680.Hw09.fs.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

public class FileSearchVisitorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void testFileSearchVisitorForAJava() {
        FileSearchVisitor visitor = new FileSearchVisitor("A.java");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size(), "Should find one file named A.java");
        assertEquals("A.java", foundFiles.getFirst().getName(), "The file found should be A.java");
    }

    @Test
    public void testFileSearchVisitorForReadmeMd() {
        FileSearchVisitor visitor = new FileSearchVisitor("readme.md");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size(), "Should find one file named readme.md");
        assertEquals("readme.md", foundFiles.getFirst().getName(), "The file found should be readme.md");
    }

    @Test
    public void testFileSearchVisitorForBJava() {
        FileSearchVisitor visitor = new FileSearchVisitor("B.java");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size(), "Should find one file named B.java");
        assertEquals("B.java", foundFiles.getFirst().getName(), "The file found should be B.java");
    }

    @Test
    public void testFileSearchVisitorForATestJava() {
        FileSearchVisitor visitor = new FileSearchVisitor("ATest.java");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size(), "Should find one file named ATest.java");
        assertEquals("ATest.java", foundFiles.getFirst().getName(), "The file found should be ATest.java");
    }

    @Test
    public void testFileSearchVisitorForBTestJava() {
        FileSearchVisitor visitor = new FileSearchVisitor("BTest.java");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size(), "Should find one file named BTest.java");
        assertEquals("BTest.java", foundFiles.getFirst().getName(), "The file found should be BTest.java");
    }

}
