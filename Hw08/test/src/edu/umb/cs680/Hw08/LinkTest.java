package edu.umb.cs680.Hw08;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LinkTest {
        private static FileSystem fs;

        @BeforeAll
        public static void setUpFs() {
                fs = testFixture.createFs();
        }

        @Test
        void testLinkName() {
                Directory root = fs.getRootDirs().getFirst();
                Directory test = (Directory) root.getChildren().get(1);
                Directory testSrc = (Directory) test.getChildren().getFirst();
                Link rmMdLink = (Link) testSrc.getChildren().getLast();

                String actual = rmMdLink.getName();
                String expected = "rm.md";
                assertEquals(expected, actual);
        }

        @Test
        void testIsDirectory() {
                Directory root = fs.getRootDirs().getFirst();
                Directory test = (Directory) root.getChildren().get(1);
                Directory testSrc = (Directory) test.getChildren().getFirst();
                Link rmMdLink = (Link) testSrc.getChildren().getLast();
                assertFalse(rmMdLink.isDirectory());
        }

        @Test
        public void testLinkSize() {
                Directory root = fs.getRootDirs().getFirst();
                Directory test = (Directory) root.getChildren().get(1);
                Directory testSrc = (Directory) test.getChildren().getFirst();
                Link rmMdLink = (Link) testSrc.getChildren().getLast();
                int actual = rmMdLink.getSize();
                int expected = 0;
                assertEquals(expected, actual);
        }

        @Test
        public void testLinkParent() {
                Directory root = fs.getRootDirs().getFirst();
                Directory test = (Directory) root.getChildren().get(1);
                Directory testSrc = (Directory) test.getChildren().getFirst();
                Link rmMdLink = (Link) testSrc.getChildren().getLast();
                Directory parent = rmMdLink.getParent();
                String actual = parent.getName();
                String expected = "src";
                assertEquals(expected, actual);
        }

        @Test
        public void testLinkTarget() {
                Directory root = fs.getRootDirs().getFirst();
                Directory test = (Directory) root.getChildren().get(1);
                Directory testSrc = (Directory) test.getChildren().getFirst();
                Link rmMdLink = (Link) testSrc.getChildren().getLast();
                FSElement target = rmMdLink.getTarget();
                String actual = target.getName();
                String expected = "readme.md";
                assertEquals(expected, actual);
        }
}