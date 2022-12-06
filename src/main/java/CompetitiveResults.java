public class CompetitiveResults {

    private int membershipNumber;
    private double timeResult;
    private boolean isPractice;
    private int placement;
    private String discipline;
    private String tournamentName;
    private String date;

    public CompetitiveResults(double timeResult, boolean isPractice, int placement, String discipline, String tournamentName, String date, int membershipNumber) {
        this.timeResult = timeResult;
        this.isPractice = isPractice;
        this.discipline = discipline;
        this.placement = placement;
        this.tournamentName = tournamentName;
        this.date = date;
        this.membershipNumber = membershipNumber;
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

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
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

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String toString() {
        return ("Medlemsnummer: " + membershipNumber + "\n" + "Disciplin: " + discipline + "\n" +
                "Tid: " + timeResult + "\n" + "Placering: " + placement + "\n" +
                "Dato: " + date + "\n" + "Stævnenavn: " + tournamentName + "\n");
    }
}