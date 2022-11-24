import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    Database database = null;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public void Controller(Database isChangesMade) {
        this.database = isChangesMade;
    }


    public void saveData(ArrayList<Member> members) throws FileNotFoundException {

        if (database.isChangesMade() == true) {
            PrintStream output = new PrintStream(new File("data/members.csv"));

            for (Member member : members) {
                output.print(member.getFirstName());
                output.print(";");
                output.print(member.getLastName());
                output.print(";");
                output.print(member.isSwimType());
                output.print(";");
                output.print(member.getAge());
                output.print(";");
                output.print(member.isMembershipStatus());
                output.print(";");
                output.print(member.getMembershipNumber());
                output.print(";");
                output.print(member.isMembershipAgeGroup());
                output.println();


            }
            output.flush();
            output.close();
        }
        database.setChangesMade(false);
    }

    public ArrayList<Member> loadData() throws FileNotFoundException {

        Scanner reader = new Scanner(new File("data/members.csv"));

        ArrayList<Member> members = new ArrayList<>();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            System.out.println(line);

            Member memberObject = csvLine(line);

            members.add(memberObject);
        }
        return members;
    }

    private Member csvLine(String line) {
        String[] parts = line.split(";");

        Member member = new Member();
        member.setFirstName(parts[0]);
        member.setLastName(parts[1]);
        boolean swimType = Boolean.parseBoolean(parts[2]);
        member.setSwimType(swimType);
        int age = Integer.parseInt(parts[3]);
        member.setAge(age);
        boolean membershipsStatus = Boolean.parseBoolean(parts[4]);
        member.setMembershipStatus(membershipsStatus);
        int membershipNumber = Integer.parseInt(parts[5]);
        member.setMembershipNumber(membershipNumber);

        return member;
    }


}