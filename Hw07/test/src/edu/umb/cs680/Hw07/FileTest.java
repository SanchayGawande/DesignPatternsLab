package edu.umb.cs680.Hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    private String[] FileToString(File f) {
        String parentName = (f.getParent() != null) ? f.getParent().getName() : "null";
        return new String[]{
                f.getName(),
                Integer.toString(f.getSize()),
                parentName,
                f.getCreationTime().toString()
        };
    }
    @Test
    public void verifyFileEqualityA_java() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = (Directory) root.getChildren().get(0);
        File A_java = (File) src.getChildren().get(0);
        String[] expected = {"A.java", "100", "src", "2021-04-22T11:00"};
        assertArrayEquals(expected, FileToString(A_java));
    }
    @Test
    public void verifyFileEqualityB_java() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = (Directory) root.getChildren().get(0);
        File B_java = (File) src.getChildren().get(1);
        String[] expected = {"B.java", "200", "src", "2021-04-23T11:00"};
        assertArrayEquals(expected, FileToString(B_java));
    }
    @Test
    public void verifyFileEqualityATest_java() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = (Directory) root.getChildren().get(1);
        Directory testSrc = (Directory) test.getChildren().get(0);
        File ATest_java = (File) testSrc.getChildren().get(0);
        String[] expected = {"ATest.java", "250", "src", "2021-04-26T14:00"};
        assertArrayEquals(expected, FileToString(ATest_java));
    }
    @Test
    public void verifyFileEqualityBTest_java() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = (Directory) root.getChildren().get(1);
        Directory testSrc = (Directory) test.getChildren().get(0);
        File BTest_java = (File) testSrc.getChildren().get(1);
        String[] expected = {"BTest.java", "300", "src", "2021-04-27T14:00"};
        assertArrayEquals(expected, FileToString(BTest_java));
    }
    @Test
    public void verifyFileEqualityReadme_md() {
        Directory root = fs.getRootDirs().getFirst();
        File readme_md = (File) root.getChildren().get(2);
        String[] expected = {"readme.md", "50", "repo", "2021-04-28T15:00"};
        assertArrayEquals(expected, FileToString(readme_md));
    }
}
