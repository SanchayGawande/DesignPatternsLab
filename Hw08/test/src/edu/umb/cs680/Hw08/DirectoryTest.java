package edu.umb.cs680.Hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    private String[] dirToStringArray(Directory d) {
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
        Directory root = fs.getRootDirs().get(0);
        String[] expected = {"repo", "0", "3", "950", "true", "false"};
        assertArrayEquals(expected, dirToStringArray(root));
    }

    @Test
    public void verifyDirectoryEqualitySrc() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = (Directory) root.getChildren().get(0);
        String[] expected = {"src", "0", "2", "300", "true", "false"};
        assertArrayEquals(expected, dirToStringArray(src));
    }

    @Test
    public void verifyDirectoryEqualityTest() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = (Directory) root.getChildren().get(1);
        String[] expected = {"test", "0", "1", "600", "true", "false"};
        assertArrayEquals(expected, dirToStringArray(test));
    }

    @Test
    public void verifyDirectoryEqualityTestSrc() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = (Directory) root.getChildren().get(1);
        Directory test_src = (Directory) test.getChildren().get(0);
        String[] expected = {"src", "0", "3", "600", "true", "false"};
        assertArrayEquals(expected, dirToStringArray(test_src));
    }

}
