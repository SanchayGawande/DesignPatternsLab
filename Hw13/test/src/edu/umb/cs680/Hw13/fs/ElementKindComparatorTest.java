package edu.umb.cs680.Hw13.fs;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class ElementKindComparatorTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUp() {
        fs = testFixture.createFs();
    }

    @Test
    public void testElementKindComparator() {
        Directory root = fs.getRootDirs().getFirst();
        LinkedList<FSElement> sortedChildren = root.getAllChildrens(new ElementKindComparator());

        boolean foundFile = false;
        boolean foundLink = false;
        for (FSElement e : sortedChildren) {
            if (e instanceof Directory) {
                assertFalse("Directory found after file or link", foundFile || foundLink);
            } else if (e instanceof File) {
                foundFile = true;
                assertFalse("File found after link", foundLink);
            } else if (e instanceof Link) {
                foundLink = true;
            }
        }
        assertTrue("The last element should be a link", sortedChildren.getLast() instanceof Link);
    }


}


