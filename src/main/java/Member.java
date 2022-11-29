import ENUM.AgeEnums;

public class Member {

    private Subscription subscription;

    private String firstName;
    private String lastName;
    private boolean isCompetitive;
    private int age;
    private boolean membershipStatus;
    private int membershipNumber;
    private boolean isJunior;

    public Member(){
    }

    /* public Member(String firstName, String lastName, boolean competitive, int age, boolean active, int membershipNumber, boolean junior) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.competitive = competitive;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.membershipNumber = membershipNumber;
        this.membershipAgeGroup = membershipAgeGroup;
    }

    public Member(String firstName, String lastName, boolean swimType, int age, boolean membershipStatus, int membershipNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isCompetitive = isCompetitive;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.membershipNumber = membershipNumber;
        this.subscription = new Subscription(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

    public int getAge() {
        return age;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public boolean isMembershipAgeGroup() {
        return membershipAgeGroup;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompetitive(boolean competitive) {
        this.isCompetitive = competitive;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public void setMembershipNumber(int memberShipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public void setMembershipAgeGroup(boolean membershipAgeGroup) {
        this.membershipAgeGroup = membershipAgeGroup;
    }

    public AgeEnums memberAgeGroup() {

        if (age < 18) {
            return AgeEnums.UNDER_18;
        } else if (age < 60) {
            return AgeEnums.OVER_18;
        } else {
            return AgeEnums.OVER_60;
        }
    }

    public String toString() {
        return ("Fornavn: " + firstName + "\n" + "Efternavn: " + lastName + "\n" + "Svømmetype: " +
               swimType + "\n" + "Alder: " + age + "\n" + "Medlemsstatus: " + membershipStatus + " \n " + "Medlemsnummer: "
                + membershipNumber + " \n " + "Medlems aldersgrupppe: " + membershipAgeGroup + " \n ");
    }

    public Subscription getSubscription () {
        return subscription;
    }

    public double getPayment () {
        return getSubscription().getSubscriptionPerMember();
    }

}
