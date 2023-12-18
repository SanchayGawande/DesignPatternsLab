package edu.umb.cs680.Hw13.fs;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AlphabeticalComparatorTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }
    @Test
    public void getChildrenAlphabeticalOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        ArrayList<String> expectedChilderns = new ArrayList<>(Arrays.asList(
                "readme.md", "src", "test"
        ));
        LinkedList<FSElement> list2 = repo.getChildren(new AlphabeticalComparator());
        ArrayList<String> actualChilderns = new ArrayList<>();
        for (FSElement element : list2) {
            actualChilderns.add(element.getName());
        }
        assertEquals(expectedChilderns, actualChilderns);
    }

    @Test
    public void getSubDirectoriesAlphabeticalOrder() {
        List<String> subChildren = Arrays.asList("src", "test");
        Directory repo = fs.getRootDirs().getFirst();
        List<String> actualSubDirectories = new ArrayList<>();
        for (Directory dir : repo.getSubDirectories(new AlphabeticalComparator())) {
            actualSubDirectories.add(dir.getName());
        }
        assertEquals(subChildren, actualSubDirectories);
    }

    @Test
    public void getFilesAlphabeticalOrder() {
        List<String> expectedFiles = Arrays.asList("A.java", "B.java");
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        List<String> actualFiles = new ArrayList<>();
        for (File file : src.getFiles(new AlphabeticalComparator())) {
            actualFiles.add(file.getName());
        }
        assertEquals(expectedFiles, actualFiles);
    }
}