package edu.umb.cs680.Hw10.fs;
import edu.umb.cs680.Hw10.fs.util.CountingVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountingCommandTest {
    private Directory Dir;
    private CountingVisitor visitor;
    private CountingCommand command;

    @BeforeEach
    void setUp() {
        FileSystem fs = testFixture.createFs();
        Dir = fs.getRootDirs().get(0);
        command = new CountingCommand(Dir);
    }

    @Test
    void testExecute() {
        command.execute();
        visitor = command.getVisitor();
        assertTrue(visitor.getFileNum() > 0);
        assertTrue(visitor.getDirNum() > 0);
        assertTrue(visitor.getLinkNum() > 0);
    }

    @Test
    public void verifyCountingCommandFileNumbers() {
        command.execute();
        visitor = command.getVisitor();
        assertEquals(5, visitor.getFileNum());
    }

    @Test
    public void verifyCountingCommandDirNumbers() {
        command.execute();
        visitor = command.getVisitor();
        assertEquals(4, visitor.getDirNum());
    }

    @Test
    public void verifyCountingCommandLinkNumber() {
        command.execute();
        visitor = command.getVisitor();
        assertEquals(1, visitor.getLinkNum());
    }

}