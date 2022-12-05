import ENUM.AgeEnums;

public class Member {
    private Time time;
    private Subscription subscription;

    private String firstName;
    private String lastName;
    private boolean isCompetitive;
    private int age;
    private boolean isActive;
    private int membershipNumber;
    private boolean isJunior;

    public Member(){
    }

    /* public Member(String firstName, String lastName, boolean competitive, int age, boolean active, int membershipNumber, boolean junior) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.competitive = competitive;
        this.age = age;
        this.active = active;
        this.membershipNumber = membershipNumber;
        this.junior = junior;
        this.subscription = new Subscription(this);
    } */

    public Member(String firstName, String lastName, boolean isCompetitive, int age, boolean isActive, int membershipNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isCompetitive = isCompetitive;
        this.age = age;
        this.isActive = isActive;
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

    public boolean isActive() {
        return isActive;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public boolean isJunior() {
        return isJunior;
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

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setMembershipNumber(int memberShipNumber) {
        this.membershipNumber = memberShipNumber;
    }

    public void setJunior(boolean junior) {
        this.isJunior = junior;
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
                isCompetitive + "\n" + "Alder: " + age + "\n" + "Medlemsstatus: " + isActive + " \n " + "Medlemsnummer: "
                + membershipNumber + " \n " + "Medlems aldersgrupppe: " + isJunior + " \n ");
    }

    public Subscription getSubscription () {
        return subscription;
    }

    public double getPayment () {
        return getSubscription().getSubscriptionPerMember();
    }

}
