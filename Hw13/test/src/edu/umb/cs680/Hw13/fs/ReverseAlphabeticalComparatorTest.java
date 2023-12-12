package edu.umb.cs680.Hw13.fs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReverseAlphabeticalComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void getChildrenReverseOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expected = Arrays.asList(
                "test", "src", "src", "rm.md", "readme.md",
                "BTest.java", "B.java", "ATest.java", "A.java"
        );

        LinkedList<FSElement> list2 = repo.getAllChildrens(new ReverseAlphabeticalComparator());

        List<String> actual = new ArrayList<>();
        for (FSElement element : list2) {
            actual.add(element.getName());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void getSubDirectoriesReverseOrder() {
        List<String> subChildren = Arrays.asList("test", "src");

        Directory repo = fs.getRootDirs().getFirst();

        List<String> actualSubDirectories = new ArrayList<>();
        for (Directory dir : repo.getSubDirectories(new ReverseAlphabeticalComparator())) {
            actualSubDirectories.add(dir.getName());
        }

        assertEquals(subChildren, actualSubDirectories);
    }

    @Test
    public void getFilesReverseOrder() {
        List<String> expectedFiles = Arrays.asList("readme.md");

        Directory repo = fs.getRootDirs().getFirst();

        List<String> actualFiles = new ArrayList<>();
        for (File file : repo.getFiles(new ReverseAlphabeticalComparator())) {
            actualFiles.add(file.getName());
        }

        assertEquals(expectedFiles, actualFiles);
    }
}
