package kaptajner.delfinprojekt;

public class PracticeResult {

    private int membershipNumber;
    private double timeResult;
    private boolean isPractice;
    private String discipline;
    private String date;
    private boolean isJunior;

    public PracticeResult(double timeResult, boolean isPractice, String discipline, String date, int membershipNumber, boolean isJunior) {
        this.timeResult = timeResult;
        this.isPractice = isPractice;
        this.discipline = discipline;
        this.date = date;
        this.membershipNumber = membershipNumber;
        this.isJunior = isJunior;
    }

    public boolean isJunior() {
        return isJunior;
    }

    public void setJunior(boolean junior) {
        isJunior = junior;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }


    public double getResult() {
        return timeResult;
    }

    public void setTimeResult(double timeResult) {
        this.timeResult = timeResult;
    }

    public boolean isPractice() {
        return isPractice;
    }

    public void setPractice(boolean isPractice) {
        this.isPractice = isPractice;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return ("Medlemsnummer: " + membershipNumber + "\n" + "Disciplin: " + discipline + "\n" +
                "Tid: " + timeResult + "\n" + "Dato: " + date + "\n");
    }

}
