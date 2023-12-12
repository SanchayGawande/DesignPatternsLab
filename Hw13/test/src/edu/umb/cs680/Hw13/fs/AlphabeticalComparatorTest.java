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

        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "A.java", "ATest.java", "B.java", "BTest.java", "readme.md",
                "rm.md", "src", "src", "test"
        ));

        LinkedList<FSElement> list2 = repo.getAllChildrens(new AlphabeticalComparator());
        ArrayList<String> checklist = new ArrayList<>();
        for (FSElement element : list2) {
            checklist.add(element.getName());
        }

        assertEquals(list, checklist);
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
        List<String> expectedFiles = Arrays.asList("readme.md");

        Directory repo = fs.getRootDirs().getFirst();

        List<String> actualFiles = new ArrayList<>();
        for (File file : repo.getFiles(new AlphabeticalComparator())) {
            actualFiles.add(file.getName());
        }

        assertEquals(expectedFiles, actualFiles);
    }
}