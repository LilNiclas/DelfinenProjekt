public class Coach extends Member{


    private boolean isCoach;

    public Coach(String firstName, String lastName, boolean isCompetitive, int age, boolean isActive, int membershipNumber, boolean isCoach) {
        super(firstName, lastName, isCompetitive, age, isActive, membershipNumber);
        this.isCoach=isCoach;
    }

    public boolean getIsCoach() {
        return isCoach;
    }
}