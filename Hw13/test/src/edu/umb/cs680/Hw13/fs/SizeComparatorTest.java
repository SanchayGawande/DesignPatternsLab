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
    public void verifyChildrenBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedChildrens = Arrays.asList("src", "test", "readme.md");
        LinkedList<FSElement> list = repo.getChildren(new SizeComparator());
        List<String> actualChildrens = new ArrayList<>();
        list.forEach(element -> actualChildrens.add(element.getName()));
        assertEquals(expectedChildrens, actualChildrens);
    }

    @Test
    public void verifySubDirectoriesBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> subChildren = Arrays.asList("src", "test");
        List<String> actualSubDirectories = new ArrayList<>();
        repo.getSubDirectories(new SizeComparator()).forEach(dir -> actualSubDirectories.add(dir.getName()));
        assertEquals(subChildren, actualSubDirectories);
    }

    @Test
    public void verifyFilesBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        List<String> expectedFiles = Arrays.asList("A.java", "B.java");
        List<String> actualFiles = new ArrayList<>();
        src.getFiles(new SizeComparator()).forEach(file -> actualFiles.add(file.getName()));
        assertEquals(expectedFiles, actualFiles);
    }
}
