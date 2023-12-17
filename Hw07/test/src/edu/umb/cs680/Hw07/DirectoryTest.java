package edu.umb.cs680.Hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    private String[] DirToString(Directory d) {
        return new String[]{
                d.getName(),
                Integer.toString(d.getSize()),
                Integer.toString(d.countChildren()),
                Integer.toString(d.getTotalSize()),
                Boolean.toString(d.isDirectory()),
                Boolean.toString(d.isFile())
        };
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        Directory root = fs.getRootDirs().getFirst();
        String[] expected = {"repo", "0", "3", "900", "true", "false"};
        assertArrayEquals(expected, DirToString(root));
    }

    @Test
    public void verifyDirectoryEqualitySrc() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = (Directory) root.getChildren().get(0);
        String[] expected = {"src", "0", "2", "300", "true", "false"};
        assertArrayEquals(expected, DirToString(src));
    }

    @Test
    public void verifyDirectoryEqualityTest() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = (Directory) root.getChildren().get(1);
        String[] expected = {"test", "0", "1", "550", "true", "false"};
        assertArrayEquals(expected, DirToString(test));
    }

    @Test
    public void verifyDirectoryEqualityTestSrc() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = (Directory) root.getChildren().get(1);
        Directory test_src = (Directory) test.getChildren().get(0);
        String[] expected = {"src", "0", "2", "550", "true", "false"};
        assertArrayEquals(expected, DirToString(test_src));
    }




    //Additional tests For Equality
    @Test
    public void verifyEqualityOfIdenticalDirectories() {
        LocalDateTime creationTime = LocalDateTime.now();
        Directory newrepo = new Directory(null, "newrepo", 0, creationTime);
        Directory newrepo2 = new Directory(null, "newrepo", 0, creationTime);

        assertEquals(newrepo.getName(), newrepo2.getName());
        assertEquals(newrepo.getSize(), newrepo2.getSize());
        assertEquals(newrepo.getParent(), newrepo2.getParent());
        assertEquals(newrepo.getCreationTime(), newrepo2.getCreationTime());
    }

    @Test
    public void verifyInequalityDirWithDiffNames() {
        LocalDateTime creationTime = LocalDateTime.now();
        Directory newrepo = new Directory(null, "newrepo", 0, creationTime);
        Directory newrepo2 = new Directory(null, "newrepo2", 0, creationTime);

        assertNotEquals(newrepo.getName(), newrepo2.getName());
    }

    @Test
    public void verifyInequalityDirWithDiffSizes() {
        LocalDateTime creationTime = LocalDateTime.now();
        Directory newrepo = new Directory(null, "Umass", 0, creationTime);
        Directory newrepo2 = new Directory(null, "Umass", 0, creationTime);

        File file1 = new File(newrepo, "file1", 321, creationTime);
        File file2 = new File(newrepo2, "file2", 133, creationTime);

        newrepo.appendChild(file1);
        newrepo2.appendChild(file2);

        assertNotEquals(newrepo.getTotalSize(), newrepo2.getTotalSize());
    }

    @Test
    public void verifyInequalityDirWithDiffParents() {
        LocalDateTime creationTime = LocalDateTime.now();
        Directory parent1 = new Directory(null, "parent1", 0, creationTime);
        Directory parent2 = new Directory(null, "parent2", 0, creationTime);
        Directory newrepo = new Directory(parent1, "Umass", 0, creationTime);
        Directory newrepo2 = new Directory(parent2, "Umass", 0, creationTime);

        assertNotEquals(newrepo.getParent(), newrepo2.getParent());
    }

    @Test
    public void verifyInequalityDirWithDiffCreationTimes() {
        Directory newrepo = new Directory(null, "dir", 0, LocalDateTime.now());
        Directory newrepo2 = new Directory(null, "dir", 0, LocalDateTime.now().plusDays(1));

        assertNotEquals(newrepo.getCreationTime(), newrepo2.getCreationTime());
    }
}
