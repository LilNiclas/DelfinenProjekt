public class Time {
    private double Result;
    private boolean Practice;

    public Time(double result, boolean practice) {
        Result = result;
        Practice = practice;
    }

    public double getResult() {
        return Result;
    }

    public void setResult(double result) {
        Result = result;
    }

    public boolean isPractice() {
        return Practice;
    }

    public void setPractice(boolean practice) {
        Practice = practice;
    }
}