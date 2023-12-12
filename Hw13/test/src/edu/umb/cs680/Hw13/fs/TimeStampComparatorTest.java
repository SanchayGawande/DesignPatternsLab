package edu.umb.cs680.Hw13.fs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TimeStampComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void getChildrenByTimeStamp() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expected = Arrays.asList("src", "test", "readme.md");

        LinkedList<FSElement> list = repo.getChildren(new TimeStampComparator());

        List<String> actual = new ArrayList<>();
        for (FSElement element : list) {
            actual.add(element.getName());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void getSubDirectoriesByTimeStamp() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> subChildren = Arrays.asList("src", "test");

        List<String> actualSubDirectories = new ArrayList<>();
        for (Directory dir : repo.getSubDirectories(new TimeStampComparator())) {
            actualSubDirectories.add(dir.getName());
        }

        assertEquals(subChildren, actualSubDirectories);
    }

    @Test
    public void getAllChildrensByTimeStamp() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedNames = Arrays.asList("src", "A.java", "B.java", "test", "src", "ATest.java", "BTest.java", "readme.md", "rm.md");

        LinkedList<FSElement> allChildrens = repo.getAllChildrens(new TimeStampComparator());
        List<String> actualNames = new ArrayList<>();
        for (FSElement element : allChildrens) {
            actualNames.add(element.getName());
        }

        assertEquals(expectedNames, actualNames);
    }

    @Test
    public void getFilesByTimeStamp() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedFiles = Arrays.asList("readme.md");

        List<String> actualFiles = new ArrayList<>();
        for (File file : repo.getFiles(new TimeStampComparator())) {
            actualFiles.add(file.getName());
        }

        assertEquals(expectedFiles, actualFiles);
    }
}
