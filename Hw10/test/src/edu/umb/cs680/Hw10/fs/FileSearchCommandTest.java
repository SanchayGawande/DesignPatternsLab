package edu.umb.cs680.Hw10.fs;
import edu.umb.cs680.Hw10.fs.util.FileSearchVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileSearchCommandTest {
    private FileSystem fs;
    private Directory dir;
    private FileSearchVisitor visitor;
    private FileSearchCommand command;

    @BeforeEach
    void setUp() {
        fs = testFixture.createFs();
        dir = fs.getRootDirs().get(0);
    }

    @Test
    void verifyExecuteWithFile() {
        visitor = new FileSearchVisitor("A.java");
        command = new FileSearchCommand(visitor, dir);
        command.execute();
        List<File> foundFiles = visitor.getFoundFiles();
        assertFalse(foundFiles.isEmpty());
        assertEquals(1, foundFiles.size());
        assertEquals("A.java", foundFiles.get(0).getName());
    }

    @Test
    void verifyExecuteWithNonFile() {
        visitor = new FileSearchVisitor("Umb");
        command = new FileSearchCommand(visitor, dir);
        command.execute();
        List<File> foundFiles = visitor.getFoundFiles();
        assertTrue(foundFiles.isEmpty());
    }
    @Test
    public void VerifyFileSearchCommandForBJava() {
        visitor = new FileSearchVisitor("B.java");
        command = new FileSearchCommand(visitor, dir);
        command.execute();
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("B.java", foundFiles.getFirst().getName());
    }

    @Test
    public void VerifyFileSearchCommandForATestJava() {
        visitor = new FileSearchVisitor("ATest.java");
        command = new FileSearchCommand(visitor, dir);
        command.execute();
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("ATest.java", foundFiles.getFirst().getName());
    }

    @Test
    public void VerifyFileSearchCommandForBTestJava() {
        visitor = new FileSearchVisitor("BTest.java");
        command = new FileSearchCommand(visitor, dir);
        command.execute();
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("BTest.java", foundFiles.getFirst().getName());
    }

    @Test
    public void VerifyFileSearchCommandForReadmeMd() {
        visitor = new FileSearchVisitor("readme.md");
        command = new FileSearchCommand(visitor, dir);
        command.execute();
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertEquals("readme.md", foundFiles.getFirst().getName());
    }
}
