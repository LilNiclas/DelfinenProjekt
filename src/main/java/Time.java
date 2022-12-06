public class Time {
    private double timeResult;
    private boolean isPractice;
    private int placement;
    private String discipline;
    private String tournamentName;
    private String date;


    public Time(double timeResult, boolean isPractice, String discipline, String date) {
        this.timeResult = timeResult;
        this.isPractice = isPractice;
        this.discipline = discipline;
        this.date = date;
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