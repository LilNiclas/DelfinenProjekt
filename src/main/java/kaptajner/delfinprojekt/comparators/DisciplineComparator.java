package kaptajner.delfinprojekt.comparators;

import kaptajner.delfinprojekt.PracticeResult;

import java.util.Comparator;

public class DisciplineComparator implements Comparator<PracticeResult> {
    public int compare (PracticeResult p1, PracticeResult p2) {
        return p1.getDiscipline().compareTo(p2.getDiscipline());
    }
}
