package kaptajner.delfinprojekt;

import kaptajner.delfinprojekt.comparators.DisciplineComparator;
import kaptajner.delfinprojekt.comparators.ResultComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Database {

    private ArrayList<Member> database = new ArrayList<>();
    private ArrayList<Member> juniorComp = new ArrayList<>();

    private ArrayList<Coach> coachData = new ArrayList<>();

    private ArrayList<PracticeResult> practiceResult = new ArrayList<>();
    private ArrayList<CompetitiveResult> competitiveResult = new ArrayList<>();;

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
        createCompetetiveResult(126.2,false,3,"Butterfly 250 meter","El Classico","4/12-22",226);
        createCompetetiveResult(1,false,1,"Crawl 100 meter","Champions League","30/12-22",777);
        createCompetetiveResult(560,false,6,"Bryst 50 meter","Handicap Olympics","8/10-22",544);

    }

    public void createPracticeResultTestData () {
        createPracticeResult(46, true,"Hundesvømning","14/10-2001",220, false);
        createPracticeResult(20, true,"Hundesvømning","14/10-2001",320, false);
        createPracticeResult(30, true,"Hundesvømning","14/10-2001",420, false);
        createPracticeResult(25, true,"Hundesvømning","14/10-2001",520, false);
        createPracticeResult(37, true,"Hundesvømning","16/7-2010",666, false);
        createPracticeResult(46, true,"Hundesvømning","14/10-2001",220, true);
        createPracticeResult(20, true,"Hundesvømning","14/10-2001",320, true);
        createPracticeResult(30, true,"Hundesvømning","14/10-2001",420, true);
        createPracticeResult(25, true,"Hundesvømning","14/10-2001",520, true);
        createPracticeResult(37, true,"Hundesvømning","16/7-2010",666, true);
        createPracticeResult(52, true,"Brystsvømning","9/11-2011",12, false);
        createPracticeResult(48, true,"Brystsvømning","9/11-2011",15, false);
        createPracticeResult(45, true,"Brystsvømning","9/11-2011",24, false);
        createPracticeResult(62, true,"Brystsvømning","9/11-2011",7, false);
        createPracticeResult(68, true,"Brystsvømning","9/11-2011",25, false);
        createPracticeResult(52, true,"Brystsvømning","9/11-2011",12, true);
        createPracticeResult(48, true,"Brystsvømning","9/11-2011",15, true);
        createPracticeResult(45, true,"Brystsvømning","9/11-2011",24, true);
        createPracticeResult(62, true,"Brystsvømning","9/11-2011",7, true);
        createPracticeResult(68, true,"Brystsvømning","9/11-2011",25, true);

    }

    public ArrayList<Member> getMembers() {
        return database;
    }

    public ArrayList<Coach> getCoach() {
        return coachData;
    }

    public ArrayList<PracticeResult> getPracticeResults() {
        return practiceResult;
    }

    public ArrayList<CompetitiveResult> getCompetetiveResults() {
        return competitiveResult;
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

    public CompetitiveResult createCompetetiveResult(double timeResult, boolean practice, int placement, String discipline, String tournamentName, String date, int membershipNumber) {
        CompetitiveResult competitiveResultsesults = new CompetitiveResult(timeResult, practice, placement, discipline, tournamentName, date, membershipNumber);
        competitiveResult.add(competitiveResultsesults);
        return competitiveResultsesults;
    }

    public PracticeResult createPracticeResult(double timeResult, boolean practice, String discipline, String date, int membershipNumber, boolean isJunior) {
        PracticeResult practiceResults = new PracticeResult(timeResult, practice, discipline, date, membershipNumber, isJunior);
        practiceResult.add(practiceResults);
        return practiceResults;
    }

    public void sortTopFive () {
        Collections.sort(practiceResult, new DisciplineComparator().thenComparing(new ResultComparator()));
    }

}

