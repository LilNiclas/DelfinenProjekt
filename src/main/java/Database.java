import java.util.ArrayList;

public class Database {

    private ArrayList<Member> database = new ArrayList<>();
    private ArrayList<Member> juniorComp = new ArrayList<>();

    private ArrayList<Coach> coachData = new ArrayList<>();

    private ArrayList<PracticeResults> practiceResult = new ArrayList<>();
    private ArrayList<CompetitiveResults> competitiveResults = new ArrayList<>();

    private Coach coach = new Coach();


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

    public Coach createCoach(String firstName, String lastName, boolean isCompetitive, int age, boolean isActive, int membershipNumber, boolean isCoach) {
        Coach coach = new Coach(firstName, lastName, isCompetitive, age, isActive, membershipNumber, isCoach);
        coachData.add(coach);

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
        createCoach("Simon", "Leander", false, 72, true, 200, true);
        createCoach("Nidos", "Kräms", false, 23, true, 100, false);
    }

    public void createTournamentResultTestData () {
        createCompetetiveResults(126.2,false,3,"Butterfly 250 meter","El Classico","4/12-22",226);
        createCompetetiveResults(1,false,1,"Crawl 100 meter","Champions League","30/12-22",777);
        createCompetetiveResults(560,false,6,"Bryst 50 meter","Handicap Olympics","8/10-22",544);

    }

    public void createPracticeResultTestData () {
        createPracticeResults(46.91, true,"Crawl 100 meter","14/10-2001",420);
        createPracticeResults(106.71, true,"Hundesvømning 200 meter","16/7-2010",666);
        createPracticeResults(56000000, true,"Brystsvømning 46km","9/11-2011",69);
    }

    public ArrayList<Member> getMembers() {
        return database;
    }

    public ArrayList<Coach> getCoach() {
        return coachData;
    }

    public ArrayList<PracticeResults> getPracticeResults() {
        return practiceResult;
    }

    public ArrayList<CompetitiveResults> getCompetetiveResults() {
        return competitiveResults;
    }

    public ArrayList<Member> searchMembersFirstName(String searchTerm) {

        ArrayList<Member> searchResult = new ArrayList<>();

        for (Member member : database) {
            if (member.getFirstName().toLowerCase().contains(searchTerm.toLowerCase().trim())) {
                searchResult.add(member);
            }
        }
        return searchResult;
    }

    public ArrayList<Member> searchMembersMembershipNumber(int searchNumber) {

        ArrayList<Member> searchResult = new ArrayList<>();

        for (Member member : database) {
            if (member.getMembershipNumber() == searchNumber) {
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

    public void setJuniorOrSenior() {
        for (Member member : database) {
            if (member.getAge() < 18) {
                member.setJunior(true);
            } else if (member.getAge() < 18) {
                member.setJunior(false);
            }
        }
    }

    public double getTotalPayment() {
        double yearlyPayment = 0;
        for (Member member : database) {
            yearlyPayment += member.getPayment();
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

    public String getCoachFirstName() {
        return coach.getFirstName();
    }

    public CompetitiveResults createCompetetiveResults(double timeResult, boolean practice, int placement, String discipline, String tournamentName, String date, int membershipNumber) {
        CompetitiveResults competitiveResultsesults = new CompetitiveResults(timeResult, practice, placement, discipline, tournamentName, date, membershipNumber);
        competitiveResults.add(competitiveResultsesults);
        return competitiveResultsesults;
    }

    public PracticeResults createPracticeResults(double timeResult, boolean practice, String discipline, String date, int membershipNumber) {
        PracticeResults practiceResults = new PracticeResults(timeResult, practice, discipline, date, membershipNumber);
        practiceResult.add(practiceResults);
        return practiceResults;
    }

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
