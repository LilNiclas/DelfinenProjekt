public class Member {

    private String firstName;
    private String lastName;
    private boolean swimType;
    private int age;
    private boolean membershipStatus;
    private int membershipNumber;
    private boolean membershipAgeGroup;

    public Member(){
    }

    public Member(String firstName, String lastName, boolean swimType, int age, boolean membershipStatus, int membershipNumber, boolean membershipAgeGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.swimType = swimType;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.membershipNumber = membershipNumber;
        this.membershipAgeGroup = membershipAgeGroup;
    }

    public Member(String firstName, String lastName, boolean swimType, int age, boolean membershipStatus, int membershipNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.swimType = swimType;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.membershipNumber = membershipNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isSwimType() {
        return swimType;
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

    public void setSwimType(boolean swimType) {
        this.swimType = swimType;
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


    public String toString() {
        return ("Fornavn: " + firstName + "\n" + "Efternavn: " + lastName + "\n" + "Svømmetype: " +
               swimType + "\n" + "Alder: " + age + "\n" + "Medlemsstatus: " + membershipStatus + " \n " + "Medlemsnummer: "
                + membershipNumber + " \n " + "Medlems aldersgrupppe: " + membershipAgeGroup + " \n ");
    }

}
