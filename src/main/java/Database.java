import java.util.ArrayList;

public class Database {

    private ArrayList<Member> database = new ArrayList<>();

    public void createMember(String firstName, String lastName, String swimType, int age, boolean membershipStatus, int membershipNumber){

        Member member = new Member(firstName, lastName, swimType, age, membershipStatus, membershipNumber);
        database.add(member);

    }

    public void createTestData () {
        createMember("Bobby","Wassabi","Motionist",22,true,1);
        createMember("Michael","Phelps","Konkurrencesvømmer",37,true,2);
        createMember("Finn","Nemo","Motionist",5,false,3);
        createMember("Osama","Binladen","Konkurrence",54,true,4);
    }

}
