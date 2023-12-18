package edu.umb.cs680.Hw13.fs;
import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement obj1, FSElement obj2) {
        return obj2.getName().compareTo(obj1.getName());
    }
}
