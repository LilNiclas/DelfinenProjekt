import java.util.ArrayList;

public class Controller {
    Database database = new Database();

    public void createMember(String firstName, String lastName, String swimType, int age, boolean aktivitetsForm, int memberShipNumber) {
        database.createMember(firstName, lastName, swimType, age, aktivitetsForm, memberShipNumber);
    }

    public void createTestData() {
        database.createTestData();
    }

    public ArrayList<Member> getMembers() {
        return database.getMembers();
    }


}
