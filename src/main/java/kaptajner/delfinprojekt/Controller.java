package kaptajner.delfinprojekt;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private Database database;
    private FileHandler fileHandler;
    private Member member;


    public Controller() {
        this.database = new Database();
        this.fileHandler = new FileHandler();
        fileHandler.setDatabase(database);
    }

    public void createMember(String firstName, String lastName, boolean swimType, int age, boolean aktivitetsForm, int memberShipNumber) {
        database.createMember(firstName, lastName, swimType, age, aktivitetsForm, memberShipNumber);
    }

    public void createTestData() {
        database.createTestData();
    }

    public void createTestDataCoach() {
        database.createCoachData();
    }

    public void createTournamentResultTestData() {
        database.createTournamentResultTestData();
    }

    public void createPracticeResultTestData() {
        database.createPracticeResultTestData();
    }

    public void createCompetetiveResult(double timeResult, boolean practice, int placement, String discipline, String tournamentName, String date, int membershipNumber) {
        database.createCompetetiveResult(timeResult, practice, placement, discipline, tournamentName, date, membershipNumber);
    }

    public void createPracticeResult(double timeResult, boolean practice, String discipline, String date, int membershipNumber, boolean isJunior) {
        database.createPracticeResult(timeResult, practice, discipline, date, membershipNumber, isJunior);
    }

    public ArrayList<Member> getMembers() {
        return database.getMembers();
    }

    public ArrayList<Coach> getCoaches() {
        return database.getCoach();
    }

    public ArrayList<PracticeResult> getPracticeResults() {
        return database.getPracticeResults();
    }

    public ArrayList<CompetitiveResult> getCompetetiveResults() {
        return database.getCompetetiveResults();
    }

    public ArrayList<Member> searchMembersFirstName(String searchTerm) {
        return database.searchMembersFirstName(searchTerm);
    }

    public ArrayList<Member> searchMembersMembershipNumber(int searchNumber) {
        return database.searchMembersMembershipNumber(searchNumber);
    }

    public void saveMembers() {
        try {
            fileHandler.saveData(database.getMembers());
        } catch (FileNotFoundException e) {
        }
    }

    public void loadMembers() {
        try {
            ArrayList<Member> members = fileHandler.loadData();
            database.addAll(members);
        } catch (FileNotFoundException e) {
        }
    }

    public void setJuniorOrSenior() {
        database.setJuniorOrSenior();
    }

    public boolean deleteMember(Member member) {
        return database.deleteMembers(member);
    }

    public double getTotalPayment() {
        return database.getTotalPayment();
    }

    public void sortTopFive () {
        database.sortTopFive();
    }
}

