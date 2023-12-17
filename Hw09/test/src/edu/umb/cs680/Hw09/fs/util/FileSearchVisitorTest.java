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
        assertEquals(1, foundFiles.size());
        assertEquals("A.java", foundFiles.getFirst().getName());
    }

    @Test
    public void testFileSearchVisitorForBJava() {
        FileSearchVisitor visitor = new FileSearchVisitor("B.java");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("B.java", foundFiles.getFirst().getName());
    }

    @Test
    public void testFileSearchVisitorForATestJava() {
        FileSearchVisitor visitor = new FileSearchVisitor("ATest.java");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("ATest.java", foundFiles.getFirst().getName());
    }

    @Test
    public void testFileSearchVisitorForBTestJava() {
        FileSearchVisitor visitor = new FileSearchVisitor("BTest.java");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("BTest.java", foundFiles.getFirst().getName());
    }

    @Test
    public void testFileSearchVisitorForReadmeMd() {
        FileSearchVisitor visitor = new FileSearchVisitor("readme.md");
        fs.getRootDirs().getFirst().accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("readme.md", foundFiles.getFirst().getName());
    }
}
