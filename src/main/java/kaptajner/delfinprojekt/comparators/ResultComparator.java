package kaptajner.delfinprojekt.comparators;

import kaptajner.delfinprojekt.PracticeResult;

import java.util.Comparator;

public class ResultComparator implements Comparator<PracticeResult> {
    public int compare (PracticeResult p1, PracticeResult p2) {
        return Double.compare (p1.getResult(), p2.getResult());
    }
}
