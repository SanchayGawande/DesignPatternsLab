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
    public void verifyChildrenAlphabeticalOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        ArrayList<String> expectedChildrens = new ArrayList<>(Arrays.asList("readme.md", "src", "test"));
        LinkedList<FSElement> list2 = repo.getChildren(new AlphabeticalComparator());
        List<String> actualChildrens = new ArrayList<>();
        list2.forEach(e -> actualChildrens.add(e.getName()));
        assertEquals(expectedChildrens, actualChildrens);
    }

    @Test
    public void verifySubDirectoriesAlphabeticalOrder() {
        List<String> subChildren = Arrays.asList("src", "test");
        Directory repo = fs.getRootDirs().getFirst();
        List<String> actualSubDirectories = new ArrayList<>();
        repo.getSubDirectories(new AlphabeticalComparator()).forEach(dir -> actualSubDirectories.add(dir.getName()));
        assertEquals(subChildren, actualSubDirectories);
    }

    @Test
    public void verifyFilesAlphabeticalOrder() {
        List<String> expectedFiles = Arrays.asList("A.java", "B.java");
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        List<String> actualFiles = new ArrayList<>();
        src.getFiles(new AlphabeticalComparator()).forEach(file -> actualFiles.add(file.getName()));
        assertEquals(expectedFiles, actualFiles);
    }

}