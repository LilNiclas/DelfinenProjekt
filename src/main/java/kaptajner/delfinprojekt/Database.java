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
    }

    public void createCoachData() {
        createCoach("Simon", "Leander", false, 72, true, 200, true);
        createCoach("Nidos", "Kräms", false, 23, true, 100, false);
    }

    public void createTournamentResultTestData () {

    }

    public void createPracticeResultTestData () {
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

    public void setJuniorOrSenior() {
        for (Member member : database) {
            if (member.getAge() < 18) {
                member.setJunior(true);
            } else if (member.getAge() < 18) {
                member.setJunior(false);
            }
        }
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
        Collections.sort(practiceResult, new ResultComparator());
    }


}

