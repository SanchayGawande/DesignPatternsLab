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
        void VerifyNameLink() {
                Directory root = fs.getRootDirs().getFirst();
                Directory test = (Directory) root.getChildren().get(1);
                Directory testSrc = (Directory) test.getChildren().getFirst();
                Link rmmdLink = (Link) testSrc.getChildren().getLast();

                String actual = rmmdLink.getName();
                String expected = "rm.md";
                assertEquals(expected, actual);
        }

        @Test
        void VerifyIsDirectory() {
                Directory root = fs.getRootDirs().getFirst();
                Directory test = (Directory) root.getChildren().get(1);
                Directory testSrc = (Directory) test.getChildren().getFirst();
                Link rmMdLink = (Link) testSrc.getChildren().getLast();
                assertFalse(rmMdLink.isDirectory());
        }

        @Test
        void VefifyLinkSize() {
                Directory root = fs.getRootDirs().getFirst();
                Directory test = (Directory) root.getChildren().get(1);
                Directory testSrc = (Directory) test.getChildren().getFirst();
                Link rmMdLink = (Link) testSrc.getChildren().getLast();
                int actual = rmMdLink.getSize();
                int expected = 0;
                assertEquals(expected, actual);
        }

        @Test
         void verifyLinkParent() {
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
        void verifyLinkTarget() {
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