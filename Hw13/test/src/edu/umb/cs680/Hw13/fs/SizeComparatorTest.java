package edu.umb.cs680.Hw13.fs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SizeComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void getChildrenBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedChilderns = Arrays.asList(
                "src", "test", "src", "rm.md", "readme.md",
                "A.java", "B.java", "ATest.java", "BTest.java"
        );

        LinkedList<FSElement> list = repo.getAllChildrens(new SizeComparator());

        List<String> actualChilderns = new ArrayList<>();
        for (FSElement element : list) {
            actualChilderns.add(element.getName());
        }

        assertEquals(expectedChilderns, actualChilderns);
    }

    @Test
    public void getAllElementsSortedBySize() {
        Directory root = fs.getRootDirs().getFirst();
        LinkedList<FSElement> allElements = root.getAllChildrens(new SizeComparator());

        List<Integer> actualSizes = new ArrayList<>();
        for (FSElement element : allElements) {
            actualSizes.add(element.getSize());
        }

        List<Integer> expectedSizes = Arrays.asList(0, 0, 0, 0, 50, 100, 200, 250, 300);
        assertEquals(expectedSizes, actualSizes);
    }

    @Test
    public void getSubDirectoriesBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> subChildren = Arrays.asList("src", "test");

        List<String> actualSubDirectories = new ArrayList<>();
        for (Directory dir : repo.getSubDirectories(new SizeComparator())) {
            actualSubDirectories.add(dir.getName());
        }

        assertEquals(subChildren, actualSubDirectories);
    }

    @Test
    public void getFilesBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedFiles = Arrays.asList("readme.md");

        List<String> actualFiles = new ArrayList<>();
        for (File file : repo.getFiles(new SizeComparator())) {
            actualFiles.add(file.getName());
        }

        assertEquals(expectedFiles, actualFiles);
    }
}
