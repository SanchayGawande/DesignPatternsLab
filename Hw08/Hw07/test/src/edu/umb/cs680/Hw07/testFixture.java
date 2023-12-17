package edu.umb.cs680.Hw07;
import java.time.LocalDateTime;

public class testFixture {
    public static FileSystem createFs() {
        FileSystem fs = FileSystem.getFileSystem();

        Directory repo = new Directory(null, "repo", 0, LocalDateTime.now());
        fs.appendRootDir(repo);

        Directory src = new Directory(repo, "src", 0, LocalDateTime.of(2021,04,21,10,00));
        File A_java = new File(src, "A.java", 100, LocalDateTime.of(2021,04,22,11,00));
        File B_java = new File(src, "B.java", 200, LocalDateTime.of(2021,04,23,11,00));

        Directory test = new Directory(repo, "test", 0, LocalDateTime.of(2021,04,24,12,00));
        Directory test_src = new Directory(test, "src", 0, LocalDateTime.of(2021,04,25,13,00));
        File ATest_java = new File(test_src, "ATest.java", 250, LocalDateTime.of(2021,04,26,14,00));
        File BTest_java = new File(test_src, "BTest.java", 300, LocalDateTime.of(2021,04,27,14,00));

        File readme_md = new File(repo, "readme.md", 50, LocalDateTime.of(2021,04,28,15,00));

        repo.appendChild(src);
        repo.appendChild(test);
        repo.appendChild(readme_md);

        src.appendChild(A_java);
        src.appendChild(B_java);

        test.appendChild(test_src);
        test_src.appendChild(ATest_java);
        test_src.appendChild(BTest_java);

        return fs;
    }
}
