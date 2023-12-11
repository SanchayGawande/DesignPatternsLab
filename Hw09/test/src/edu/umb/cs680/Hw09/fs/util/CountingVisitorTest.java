package edu.umb.cs680.Hw09.fs.util;
import edu.umb.cs680.Hw09.fs.FileSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingVisitorTest {

    private static FileSystem fs;
    private static CountingVisitor visitor;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
        visitor = new CountingVisitor();
        fs.getRootDirs().getFirst().accept(visitor);
    }

    @Test
    public void testCountingVisitorFileNum() {
        assertEquals(5, visitor.getFileNum(), "CountingVisitor should count the correct number of files");
    }

    @Test
    public void testCountingVisitorDirNum() {

        assertEquals(4, visitor.getDirNum(), "CountingVisitor should count the correct number of directories");
    }
}
