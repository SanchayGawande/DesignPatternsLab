package edu.umb.cs680.Hw13.fs;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class ElementKindComparatorTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void verifyChildrenByTypeOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedOrder = List.of("src", "test", "readme.md");
        LinkedList<FSElement> childrens = repo.getChildren(new ElementKindComparator());
        List<String> actualOrder = new ArrayList<>();
        childrens.forEach(element -> actualOrder.add(element.getName()));
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void verifySubDirectoriesByTypeOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedSubDirsOrder = List.of("src", "test");
        List<String> actualSubDirsOrder = new ArrayList<>();
        repo.getSubDirectories(new ElementKindComparator()).forEach(dir -> actualSubDirsOrder.add(dir.getName()));
        assertEquals(expectedSubDirsOrder, actualSubDirsOrder);
    }

    @Test
    public void verifyFilesByTypeOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        List<String> expectedFilesOrder = List.of("A.java", "B.java");
        List<String> actualFilesOrder = new ArrayList<>();
        src.getFiles(new ElementKindComparator()).forEach(file -> actualFilesOrder.add(file.getName()));
        assertEquals(expectedFilesOrder, actualFilesOrder);
    }

}
