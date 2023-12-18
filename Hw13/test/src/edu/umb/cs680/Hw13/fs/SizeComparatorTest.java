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
                "src", "test", "readme.md"
        );
        LinkedList<FSElement> list = repo.getChildren(new SizeComparator());
        List<String> actualChilderns = new ArrayList<>();
        for (FSElement element : list) {
            actualChilderns.add(element.getName());
        }
        assertEquals(expectedChilderns, actualChilderns);
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
        Directory src = (Directory) repo.getChildren().get(0);
        List<String> expectedFiles = Arrays.asList("A.java","B.java");
        List<String> actualFiles = new ArrayList<>();
        for (File file : src.getFiles(new SizeComparator())) {
            actualFiles.add(file.getName());
        }
        assertEquals(expectedFiles, actualFiles);
    }
}
