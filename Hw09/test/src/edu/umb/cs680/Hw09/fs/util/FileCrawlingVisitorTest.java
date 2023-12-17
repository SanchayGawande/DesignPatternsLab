package edu.umb.cs680.Hw09.fs.util;
import edu.umb.cs680.Hw09.fs.File;
import edu.umb.cs680.Hw09.fs.FileSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        LinkedList<File> Filesvisited = visitor.getFiles();
        List<String> FileNames = new ArrayList<>();

        for (File file : Filesvisited) {
            FileNames.add(file.getName());
        }
        assertTrue(FileNames.contains("A.java"));
        assertTrue(FileNames.contains("B.java"));
        assertTrue(FileNames.contains("ATest.java"));
        assertTrue(FileNames.contains("BTest.java"));
        assertTrue(FileNames.contains("readme.md"));
    }
}