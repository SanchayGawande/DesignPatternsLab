package edu.umb.cs680.Hw10.fs;
import edu.umb.cs680.Hw10.fs.util.FileCrawlingVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingCommandTest {
    private FileSystem fs;
    private Directory rootDir;
    private FileCrawlingVisitor visitor;
    private FileCrawlingCommand command;

    @BeforeEach
    void setUp() {
        fs = testFixture.createFs();
        rootDir = fs.getRootDirs().get(0);
        visitor = new FileCrawlingVisitor();
        command = new FileCrawlingCommand(visitor, rootDir);
    }

    @Test
    void testExecute() {
        command.execute();
        assertNotNull(visitor.getFiles());
    }

    @Test
    void verifyExecuteFiles() {
        command.execute();
        List<File> crawledFiles = visitor.getFiles();
        assertFalse(crawledFiles.isEmpty());
        assertEquals(5, crawledFiles.size());
    }

    @Test
    void verifyExecuteFilesNull() {
        Directory emptyDir = new Directory(null, "empty", 0, LocalDateTime.now());
        FileCrawlingCommand emptyDirCommand = new FileCrawlingCommand(new FileCrawlingVisitor(), emptyDir);
        emptyDirCommand.execute();
        List<File> crawledFiles = visitor.getFiles();
        assertTrue(crawledFiles.isEmpty());
    }

    @Test
    public void verifyFileCrawlingCommand() {
        command.execute();
        LinkedList<File> FilesVisited = visitor.getFiles();
        List<String> FileNames = new ArrayList<>();

        for (File file : FilesVisited) {
            FileNames.add(file.getName());
            System.out.println("Found file: " + file.getName());
        }
        assertTrue(FileNames.contains("A.java"));
        assertTrue(FileNames.contains("B.java"));
        assertTrue(FileNames.contains("ATest.java"));
        assertTrue(FileNames.contains("BTest.java"));
        assertTrue(FileNames.contains("readme.md"));
    }
}
