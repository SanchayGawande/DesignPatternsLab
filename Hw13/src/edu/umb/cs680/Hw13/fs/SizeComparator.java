package edu.umb.cs680.Hw13.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement obj1, FSElement obj2) {
        return (obj1.getSize()-obj2.getSize());
    }
}