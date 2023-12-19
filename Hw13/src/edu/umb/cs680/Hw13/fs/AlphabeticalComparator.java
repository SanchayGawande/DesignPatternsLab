package edu.umb.cs680.Hw13.fs;
import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement obj1, FSElement obj2) {
        return obj1.getName().compareTo(obj2.getName());
    }
}

