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
    public void verifySingletonInstance() {
        FileSystem FS2 = FileSystem.getFileSystem();
        assertSame(fs, FS2);
    }

    @Test
    public void appendRootDirAddsDirectory() {
        Directory newRoot = new Directory(null, "newRoot", 0, LocalDateTime.now());
        int TrueSize = fs.getRootDirs().size();
        fs.appendRootDir(newRoot);
        assertEquals(TrueSize + 1, fs.getRootDirs().size());
    }

    @Test
    public void appendRootDirMultipleDirectories() {
        Directory RootNew = new Directory(null, "RootNew", 0, LocalDateTime.now());
        Directory RootNew2 = new Directory(null, "RootNew2", 0, LocalDateTime.now());
        fs.appendRootDir(RootNew);
        fs.appendRootDir(RootNew2);
        assertTrue(fs.getRootDirs().contains(RootNew) && fs.getRootDirs().contains(RootNew2));
    }

    @Test
    public void getRootDirsReturnsCorrectDirectories() {
        int expectedTrueSize = testFixture.createFs().getRootDirs().size();
        assertEquals(expectedTrueSize, fs.getRootDirs().size());
    }
}
