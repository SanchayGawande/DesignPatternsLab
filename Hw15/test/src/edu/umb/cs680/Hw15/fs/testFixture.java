package edu.umb.cs680.Hw15.fs;
import edu.umb.cs680.Hw15.fs.Directory;
import edu.umb.cs680.Hw15.fs.File;
import edu.umb.cs680.Hw15.fs.FileSystem;
import edu.umb.cs680.Hw15.fs.Link;

import java.time.LocalDateTime;

public class testFixture {
    public static FileSystem createFs() {
        FileSystem fs = FileSystem.getFileSystem();

        Directory repo = new Directory(null, "repo", 0, LocalDateTime.now());
        fs.appendRootDir(repo);

        Directory src = new Directory(repo, "src", 0, LocalDateTime.of(2021, 4, 20, 10, 0));
        File A_java = new File(src, "A.java", 100, LocalDateTime.of(2021, 4, 21, 11, 0));
        File B_java = new File(src, "B.java", 200, LocalDateTime.of(2021, 4, 21, 11, 1));

        Directory test = new Directory(repo, "test", 0, LocalDateTime.of(2021, 4, 22, 12, 0));
        Directory test_src = new Directory(test, "src", 0, LocalDateTime.of(2021, 4, 23, 13, 0));
        File ATest_java = new File(test_src, "ATest.java", 250, LocalDateTime.of(2021, 4, 24, 14, 0));
        File BTest_java = new File(test_src, "BTest.java", 300, LocalDateTime.of(2021, 4, 24, 14, 0));

        File readme_md = new File(repo, "readme.md", 50, LocalDateTime.of(2021, 4, 28, 15, 0));
        Link rm_md = new Link(test_src, "rm.md", LocalDateTime.of(2021, 4, 29, 15, 0), readme_md);

        repo.appendChild(src);
        repo.appendChild(test);
        repo.appendChild(readme_md);

        src.appendChild(A_java);
        src.appendChild(B_java);

        test.appendChild(test_src);
        test_src.appendChild(ATest_java);
        test_src.appendChild(BTest_java);
        test_src.appendChild(rm_md);

        return fs;
    }
}
