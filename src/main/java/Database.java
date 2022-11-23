import java.util.ArrayList;

public class Database {

    private ArrayList<Member> database = new ArrayList<>();

    public Member createMember(String firstName, String lastName, String swimType, int age, boolean membershipStatus, int membershipNumber) {

        Member member = new Member(firstName, lastName, swimType, age, membershipStatus, membershipNumber);
        database.add(member);

        return member;
    }

    public void createTestData() {
        createMember("Bobby", "Wassabi", "Motionist", 22, true, 1);
        createMember("Michael", "Phelps", "Konkurrencesvømmer", 37, true, 2);
        createMember("Finn", "Nemo", "Motionistsvømmer", 6, false, 3);
        createMember("Osama", "Binladen", "Konkurrencesvømmer", 54, true, 4);
        createMember("Ole","bole","Motionist",23,true,5);
    }

    public ArrayList<Member> getMembers() {
        return database;
    }


}
