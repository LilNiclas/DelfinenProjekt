package Comparator;

import CompetetiveResults.CompetetiveResults;

import java.util.Comparator;

public class ResultComparator implements Comparator<CompetetiveResults> {
    public int compare (Time t1, Time t2) {
        return Double.compare (t1.getTime(), t2.getTime());
    }
}
