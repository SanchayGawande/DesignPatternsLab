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
    public void verifyChildrenReverseOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedChildrens = Arrays.asList("test", "src", "readme.md");
        LinkedList<FSElement> list2 = repo.getChildren(new ReverseAlphabeticalComparator());
        List<String> actualChildrens = new ArrayList<>();
        list2.forEach(element -> actualChildrens.add(element.getName()));
        assertEquals(expectedChildrens, actualChildrens);
    }

    @Test
    public void verifySubDirectoriesReverseOrder() {
        List<String> subChildren = Arrays.asList("test", "src");
        Directory repo = fs.getRootDirs().getFirst();
        List<String> actualSubDirectories = new ArrayList<>();
        repo.getSubDirectories(new ReverseAlphabeticalComparator()).forEach(dir -> actualSubDirectories.add(dir.getName()));
        assertEquals(subChildren, actualSubDirectories);
    }

    @Test
    public void verifyFilesReverseOrder() {
        List<String> expectedFiles = Arrays.asList("B.java", "A.java");
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        List<String> actualFiles = new ArrayList<>();
        src.getFiles(new ReverseAlphabeticalComparator()).forEach(file -> actualFiles.add(file.getName()));
        assertEquals(expectedFiles, actualFiles);
    }
}
