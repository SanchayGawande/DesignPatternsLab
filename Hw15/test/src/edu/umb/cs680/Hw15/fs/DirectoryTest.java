package edu.umb.cs680.Hw15.fs;
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
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> alphabeticalComparator = Comparator.comparing(FSElement::getName);
        List<String> DefaultNames=new ArrayList<>();
        List<String> NamesExpected = List.of("readme.md", "src", "test");
        List<FSElement> sorted_list=repo.getChildren(alphabeticalComparator);
        sorted_list.forEach(e->DefaultNames.add(e.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }

    @Test
    public void verifyChildrenReverseAlphabeticalOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> reverseAlphabeticalComparator = (e1, e2) -> e2.getName().compareTo(e1.getName());
        List<String> NamesExpected = List.of("test", "src", "readme.md");
        List<FSElement> sorted_list = repo.getChildren(reverseAlphabeticalComparator);
        List<String> DefaultNames = new ArrayList<>();
        sorted_list.forEach(e -> DefaultNames.add(e.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }

    @Test
    public void verifyChildrenSortedBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> sizeComparator = Comparator.comparingInt(FSElement::getSize);
        List<Integer> expectedSizes = List.of(0, 0, 50);
        List<FSElement> sorted_list = repo.getChildren(sizeComparator);
        List<Integer> DefaultSizes = new ArrayList<>();
        sorted_list.forEach(e -> DefaultSizes.add(e.getSize()));
        assertEquals(expectedSizes, DefaultSizes);
    }

    @Test
    public void verifyChildrenSortedByTimestamp() {
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> timestampComparator = Comparator.comparing(FSElement::getCreationTime);
        List<String> NamesExpected = List.of("src", "test", "readme.md");
        List<FSElement> sorted_list = repo.getChildren(timestampComparator);
        List<String> DefaultNames = new ArrayList<>();
        sorted_list.forEach(element -> DefaultNames.add(element.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }

    @Test
    public void verifySubDirectoriesAlphabeticalOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> alphabeticalComparator = Comparator.comparing(FSElement::getName);
        List<String> NamesExpected = List.of("src", "test");
        List<Directory> sorted_list = repo.getSubDirectories(alphabeticalComparator);
        List<String> DefaultNames = new LinkedList<>();
        sorted_list.forEach(dir -> DefaultNames.add(dir.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }

    @Test
    public void verifySubDirectoriesReverseAlphabeticalOrder() {
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> reverseAlphabeticalComparator = (e1, e2) -> e2.getName().compareTo(e1.getName());
        List<String> NamesExpected = List.of("test", "src");
        List<Directory> sorted_list = repo.getSubDirectories(reverseAlphabeticalComparator);
        List<String> DefaultNames = new LinkedList<>();
        sorted_list.forEach(dir -> DefaultNames.add(dir.getName()));
        assertEquals(NamesExpected, DefaultNames);
    }

    @Test
    public void verifySubDirectoriesSortedBySize() {
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> sizeComparator = Comparator.comparingInt(FSElement::getSize);
        List<Integer> expectedSizes = List.of(0,0);
        List<Directory> sorted_list = repo.getSubDirectories(sizeComparator);
        List<Integer> DefaultSizes = new LinkedList<>();
        sorted_list.forEach(dir -> DefaultSizes.add(dir.getSize()));
        assertEquals(expectedSizes, DefaultSizes);
    }

    @Test
    public void verifySubDirectoriesSortedByTimestamp() {
        Directory repo = fs.getRootDirs().getFirst();
        Comparator<FSElement> timestampComparator = Comparator.comparing(FSElement::getCreationTime);
        List<String> expectedDirectoryNames = List.of("src", "test");
        List<Directory> sorted_list = repo.getSubDirectories(timestampComparator);
        List<String> DefaultNames = new ArrayList<>();
        sorted_list.forEach(element -> DefaultNames.add(element.getName()));
        assertEquals(expectedDirectoryNames, DefaultNames);
    }

}

