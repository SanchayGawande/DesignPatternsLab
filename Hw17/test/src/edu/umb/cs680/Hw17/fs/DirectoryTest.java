package edu.umb.cs680.Hw17.fs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryTest{
    private static FileSystem fs;
    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void verifyChildrenAlphabeticalOrder() {
        Directory root = fs.getRootDirs().getFirst();
        Comparator<FSElement> alphabeticalComparator = Comparator.comparing(FSElement::getName);
        List<String> DefaultNames=new ArrayList<>();
        List<String> NamesExpected = List.of("readme.md", "src", "test");
        List<FSElement> sorted_list=root.getChildren(alphabeticalComparator);
        sorted_list.forEach(e->DefaultNames.add(e.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }

    @Test
    public void verifyChildrenReverseAlphabeticalOrder() {
        Directory root = fs.getRootDirs().getFirst();
        Comparator<FSElement> reverseAlphabeticalComparator = (e1, e2) -> e2.getName().compareTo(e1.getName());
        List<String> NamesExpected = List.of("test", "src", "readme.md");
        List<FSElement> sorted_list = root.getChildren(reverseAlphabeticalComparator);
        List<String> DefaultNames = new ArrayList<>();
        sorted_list.forEach(e -> DefaultNames.add(e.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }

    @Test
    public void verifyChildrenSortedBySize() {
        Directory root = fs.getRootDirs().getFirst();
        Comparator<FSElement> sizeComparator = Comparator.comparingInt(FSElement::getSize);
        List<Integer> expectedSizes = List.of(0, 0, 50);
        List<FSElement> sorted_list = root.getChildren(sizeComparator);
        List<Integer> actualSizes = new ArrayList<>();
        sorted_list.forEach(e -> actualSizes.add(e.getSize()));
        assertEquals(expectedSizes, actualSizes);
    }

    @Test
    public void verifyChildrenSortedByTimestamp() {
        Directory root = fs.getRootDirs().getFirst();
        Comparator<FSElement> timestampComparator = Comparator.comparing(FSElement::getCreationTime);
        List<String> NamesExpected = List.of("src", "test", "readme.md");
        List<FSElement> sorted_list = root.getChildren(timestampComparator);
        List<String> DefaultNames = new ArrayList<>();
        sorted_list.forEach(element -> DefaultNames.add(element.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }

    @Test
    public void verifySubDirectoriesAlphabeticalOrder() {
        Directory root = fs.getRootDirs().getFirst();
        Comparator<FSElement> alphabeticalComparator = Comparator.comparing(FSElement::getName);
        List<String> NamesExpected = List.of("src", "test");
        List<String> DefaultNames = new LinkedList<>();
        root.getSubDirectories(alphabeticalComparator).forEach(dir -> DefaultNames.add(dir.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }
    @Test
    public void verifySubDirectoriesReverseAlphabeticalOrder() {
        Directory root = fs.getRootDirs().getFirst();
        Comparator<FSElement> reverseAlphabeticalComparator = (e1, e2) -> e2.getName().compareTo(e1.getName());
        List<String> NamesExpected = List.of("test", "src");
        List<String> DefaultNames = new LinkedList<>();
        for (Directory dir : root.getSubDirectories(reverseAlphabeticalComparator)) {
            DefaultNames.add(dir.getName());
        }
        assertEquals(NamesExpected, DefaultNames);
    }
    @Test
    public void verifySubDirectoriesBySize() {
        Directory root = fs.getRootDirs().getFirst();
        Comparator<FSElement> sizeComparator = Comparator.comparingInt(FSElement::getSize);
        List<Integer> expectedSizes = List.of(0,0);
        List<Integer> actualSizes = new LinkedList<>();
        root.getSubDirectories(sizeComparator).forEach(dir -> actualSizes.add(dir.getSize()));
        assertEquals(expectedSizes, actualSizes);

    }

    @Test
    public void verifySubDirectoriesByTimestamp() {
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> timestampComparator = Comparator.comparing(FSElement::getCreationTime);
        List<String> expectedDirectoryNames = List.of("src", "test");
        LinkedList<FSElement> allChildren = repo.getChildren(timestampComparator);
        List<String> actualDirectoryNames = new LinkedList<>();
        for (FSElement element : allChildren) {
            if (element instanceof Directory) {
                actualDirectoryNames.add(element.getName());
            }}
        assertEquals(expectedDirectoryNames, actualDirectoryNames);

    }

    @Test
    public void verifyFilesAlphabeticalOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        Comparator<FSElement> alphabeticalComparator = Comparator.comparing(FSElement::getName);
        List<String> expectedFileNames = List.of("A.java", "B.java");
        List<String> actualFileNames = new LinkedList<>();
        src.getFiles(alphabeticalComparator).forEach(file -> actualFileNames.add(file.getName()));
        assertEquals(expectedFileNames, actualFileNames);
    }
    @Test
    public void verifyFilesBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        Comparator<FSElement> sizeComparator = Comparator.comparingInt(FSElement::getSize);
        List<Integer> expectedFileSizes = List.of(100, 200);
        List<Integer> actualFileSizes = new LinkedList<>();
        src.getFiles(sizeComparator).forEach(file -> actualFileSizes.add(file.getSize()));
        assertEquals(expectedFileSizes, actualFileSizes);
    }

    @Test
    public void verifyFilesByTimestamp() {
        Directory repo = fs.getRootDirs().getFirst();
        Directory src = (Directory) repo.getChildren().get(0);
        Comparator<FSElement> timestampComparator = Comparator.comparing(FSElement::getCreationTime);
        List<String> expectedFileNames = List.of("A.java", "B.java");
        LinkedList<FSElement> allChildren = src.getChildren(timestampComparator);
        List<String> actualFileNames = new LinkedList<>();
        for (FSElement element : allChildren) {
            if (element instanceof File) {
                actualFileNames.add(element.getName());
            }}
        assertEquals(expectedFileNames, actualFileNames);
    }
}
