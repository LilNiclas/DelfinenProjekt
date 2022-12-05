import java.util.ArrayList;
import java.util.stream.DoubleStream;

public class Database {

    private ArrayList<Member> database = new ArrayList<>();
    private ArrayList<Member> juniorComp = new ArrayList<>();

    private ArrayList<Coach> coachJunior = new ArrayList<>();
    private ArrayList<Coach> coachSenior = new ArrayList<>();


    private boolean changesMade = true;

    public boolean isChangesMade() {
        return changesMade;
    }

    public void setChangesMade(boolean changesMade) {
        this.changesMade = changesMade;
    }

    public Member createMember(String firstName, String lastName, boolean competitive, int age, boolean active, int membershipNumber) {

        Member member = new Member(firstName, lastName, competitive, age, active, membershipNumber);
        database.add(member);

        return member;
    }

    public Coach createCoachJunior(String firstName, String lastName, boolean isCompetitive, int age, boolean isActive, int membershipNumber, boolean isCoach) {
        Coach trainer = new Coach(firstName, lastName, isCompetitive, age, isActive, membershipNumber, isCoach);
        coachJunior.add(trainer);

        return trainer;
    }

    public Coach createCoachSenior(String firstName, String lastName, boolean isCompetitive, int age, boolean isActive, int membershipNumber, boolean isCoach) {
        Coach coach = new Coach(firstName, lastName, isCompetitive, age, isActive, membershipNumber, isCoach);
        coachSenior.add(coach);

        return coach;
    }

    public void createTestData() {
        createMember("Bobby", "Wassabi", false, 22, true, 1);
        createMember("Michael", "Phelps", true, 37, false, 2);
        createMember("Finn", "Nemo", false, 6, true, 3);
        createMember("Lonny", "Dahmer", true, 61, true, 4);
        createMember("Ole", "Spole", false, 23, false, 5);
    }

    public void createCoachData() {
        createCoachJunior("Simon", "Leander", false, 72, true, 200, true);
        createCoachSenior("Nidos", "Kräms", false, 23, true, 100, true);
    }

    public ArrayList<Member> getMembers() {
        return database;
    }

    public ArrayList<Member> searchMembersFirstName(String searchTerm) {

        ArrayList<Member> searchResult = new ArrayList<>();

        for (Member member: database) {
            if (member.getFirstName().toLowerCase().contains(searchTerm.toLowerCase().trim())) {
                searchResult.add(member);
            }
        }
        return searchResult;
    }

    public ArrayList<Member> searchMembersMembershipNumber(int searchNumber) {

        ArrayList<Member> searchResult = new ArrayList<>();

        for (Member member: database) {
            if (member.getMembershipNumber()==searchNumber) {
                searchResult.add(member);
            }
        }
        return searchResult;
    }

    public boolean deleteMembers(Member member) {
        boolean deleteMember = database.remove(member);
        return deleteMember;
    }

    public void addAll(ArrayList<Member> members) {
        database.addAll(members);
    }

    public void setJuniorOrSenior(){
        for (Member member : database) {
            if (member.getAge() < 18) {
                member.setJunior(true);
            } else if (member.getAge() < 18) {
                member.setJunior(false);
            }
        }
    }

    public double getTotalPayment () {
        double yearlyPayment=0;
        for (Member member : database) {
            yearlyPayment+=member.getPayment();
        }
        return yearlyPayment;
    }

    public Member addSeniorTeam() {
        for (Member member : database) {
            if (member.isJunior() == false) {
                return member;
            }
        }
        return null;

    }

    public ArrayList<Member> addJuniorTeam() {
        for (Member member : database) {
            if (member.isJunior() == true) {
                juniorComp.add(member);
            }
        }
        return null;
    }

/*
    public void teamJteamS() {
        for(Member member : database) {
            if (member.isJunior()==true) {
                coachJunior.add(member);
            } else {
                coa
            }
        }
    }*/
