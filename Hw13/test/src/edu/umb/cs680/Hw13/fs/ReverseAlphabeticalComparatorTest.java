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
        List<String> expectedChilderns = Arrays.asList(
                "test", "src", "readme.md"
        );
        LinkedList<FSElement> list2 = repo.getChildren(new ReverseAlphabeticalComparator());
        List<String> actualChilderns = new ArrayList<>();
        for (FSElement element : list2) {
            actualChilderns.add(element.getName());
        }
        assertEquals(expectedChilderns, actualChilderns);
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
        List<String> expectedFiles = Arrays.asList("B.java", "A.java");
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        List<String> actualFiles = new ArrayList<>();
        for (File file : src.getFiles(new ReverseAlphabeticalComparator())) {
            actualFiles.add(file.getName());
        }
        assertEquals(expectedFiles, actualFiles);
    }
}
