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
