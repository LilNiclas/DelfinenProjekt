import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private Database database;
    private FileHandler fileHandler;


    public Controller() {
        this.database = new Database();
        this.fileHandler = new FileHandler();
        fileHandler.setDatabase(database);
    }

    public void createMember(String firstName, String lastName, boolean swimType, int age, boolean aktivitetsForm, int memberShipNumber, boolean membershipAgeGroup) {
        database.createMember(firstName, lastName, swimType, age, aktivitetsForm, memberShipNumber, membershipAgeGroup);
    }

    public void createTestData() {
        database.createTestData();
    }

    public ArrayList<Member> getMembers() {
        return database.getMembers();
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

    public boolean deleteMember(Member member) {
        return database.deleteMembers(member);
    }

}
