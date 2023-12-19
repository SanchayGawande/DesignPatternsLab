package edu.umb.cs680.Hw17.fs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
class FileTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void verifyFilesAlphabeticalOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        Comparator<FSElement> alphabeticalComparator = Comparator.comparing(FSElement::getName);
        List<String> expectedFileNames = List.of("A.java", "B.java");
        List<FSElement> sorted_list = src.getChildren(alphabeticalComparator);
        List<String> DefaultNames = new LinkedList<>();
        sorted_list.forEach(dir -> DefaultNames.add(dir.getName()));
        assertEquals(expectedFileNames, DefaultNames);
    }

    @Test
    public void verifyFilesReverseAlphabeticalOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        Comparator<FSElement> reverseAlphabeticalComparator = Comparator.comparing(FSElement::getName).reversed();
        List<String> expectedFileNames = List.of("B.java", "A.java");
        List<FSElement> sorted_list = src.getChildren(reverseAlphabeticalComparator);
        List<String> defaultNames = new LinkedList<>();
        sorted_list.forEach(dir -> defaultNames.add(dir.getName()));
        assertEquals(expectedFileNames, defaultNames);
    }

    @Test
    public void verifyFilesSortedBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        Comparator<FSElement> sizeComparator = Comparator.comparingInt(FSElement::getSize);
        List<Integer> expectedFileSizes = List.of(100, 200);
        List<FSElement> sorted_list = src.getChildren(sizeComparator);
        List<Integer> DefaultSizes = new LinkedList<>();
        sorted_list.forEach(dir -> DefaultSizes.add(dir.getSize()));
        assertEquals(expectedFileSizes, DefaultSizes);
    }

    @Test
    public void verifyFilesBySortedTimestamp() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        Comparator<FSElement> timestampComparator = Comparator.comparing(FSElement::getCreationTime);
        List<String> expectedFileNames = List.of("A.java", "B.java");
        List<FSElement> sorted_list = src.getChildren(timestampComparator);
        List<String > DefaultNames = new LinkedList<>();
        sorted_list.forEach(dir -> DefaultNames.add(dir.getName()));
        assertEquals(expectedFileNames, DefaultNames);
    }

}