package edu.umb.cs680.Hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void verifyInstanceIsSingleton() {
        FileSystem FS2 = FileSystem.getFileSystem();
        assertSame(fs, FS2);
    }

    @Test
    public void appendRootDirAddsDirectory() {
        Directory newRoot = new Directory(null, "newRoot", 0, LocalDateTime.now());
        int originalSize = fs.getRootDirs().size();
        fs.appendRootDir(newRoot);
        assertEquals(originalSize + 1, fs.getRootDirs().size());
    }

    @Test
    public void appendRootDirMultipleDirectories() {
        Directory newRoot1 = new Directory(null, "newRoot1", 0, LocalDateTime.now());
        Directory newRoot2 = new Directory(null, "newRoot2", 0, LocalDateTime.now());
        fs.appendRootDir(newRoot1);
        fs.appendRootDir(newRoot2);
        assertTrue(fs.getRootDirs().contains(newRoot1) && fs.getRootDirs().contains(newRoot2));
    }

    @Test
    public void getRootDirsReturnsCorrectDirectories() {
        int expectedSize = testFixture.createFs().getRootDirs().size();
        assertEquals(expectedSize, fs.getRootDirs().size());
    }
}
