import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private Database database;
    private Subscription subscription;
    private FileHandler fileHandler;


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

    public void createCompetetiveResults(double timeResult, boolean practice, int placement, String discipline, String tournamentName, String date, int membershipNumber) {
        database.createCompetetiveResults(timeResult, practice, placement, discipline, tournamentName, date, membershipNumber);
    }

    public void createPracticeResults(double timeResult, boolean practice, String discipline, String date, int membershipNumber) {
        database.createPracticeResults(timeResult, practice, discipline, date, membershipNumber);
    }

    public ArrayList<Member> getMembers() {
        return database.getMembers();
    }

    public ArrayList<Coach> getCoaches() {
        return database.getCoach();
    }

    public ArrayList<PracticeResults> getPracticeResults() {
        return database.getPracticeResults();
    }

    public ArrayList<CompetitiveResults> getCompetetiveResults() {
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

    public ArrayList<Member> addJuniorTeam() {
        return database.addJuniorTeam();
    }

    public Member addSeniorTeam() {
        return database.addSeniorTeam();
    }

    public String getCoachFirstName() {
        return database.getCoachFirstName();
    }
}

