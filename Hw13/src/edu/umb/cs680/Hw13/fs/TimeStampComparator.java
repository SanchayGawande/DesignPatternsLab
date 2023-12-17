package edu.umb.cs680.Hw13.fs;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {

        @Override
        public int compare(FSElement obj1, FSElement obj2) {
            return obj1.getCreationTime().compareTo(obj2.getCreationTime());
        }
    }



