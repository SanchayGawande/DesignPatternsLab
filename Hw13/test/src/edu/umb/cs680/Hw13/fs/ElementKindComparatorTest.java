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
    public void getChildrenByTypeOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedOrder = List.of("src", "test", "readme.md");
        LinkedList<FSElement> children = repo.getChildren(new ElementKindComparator());
        List<String> actualOrder = new ArrayList<>();
        for (FSElement element : children) {
            actualOrder.add(element.getName());
        }
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void getSubDirectoriesByTypeOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        List<String> expectedSubDirsOrder = List.of("src", "test");

        List<String> actualSubDirsOrder = new ArrayList<>();
        for (Directory dir : repo.getSubDirectories(new ElementKindComparator())) {
            actualSubDirsOrder.add(dir.getName());
        }

        assertEquals(expectedSubDirsOrder, actualSubDirsOrder);
    }

    @Test
    public void getFilesByTypeOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        List<String> expectedFilesOrder = List.of("A.java", "B.java");

        List<String> actualFilesOrder = new ArrayList<>();
        for (File file : src.getFiles(new ElementKindComparator())) {
            actualFilesOrder.add(file.getName());
        }

        assertEquals(expectedFilesOrder, actualFilesOrder);
    }
}
