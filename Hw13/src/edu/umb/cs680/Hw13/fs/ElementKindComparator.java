package edu.umb.cs680.Hw13.fs;  // Adjust the package name as needed

import java.util.Comparator;

public class ElementKindComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement e1, FSElement e2) {
        int rank1 = getTypeRank(e1);
        int rank2 = getTypeRank(e2);

        return Integer.compare(rank1, rank2);
    }

    private int getTypeRank(FSElement element) {
        if (element instanceof Directory) {
            return 1;
        } else if (element instanceof File) {
            return 2;
        } else if (element instanceof Link) {
            return 3;
        } else {
            return 4;
        }
    }
}
