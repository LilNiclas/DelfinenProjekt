import java.util.InputMismatchException;
import java.util.Scanner;

public class Userinterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();

    public void start() {
        controller.createTestData();
        System.out.println("Velkommen til Delfin svømmeklub");
        boolean menuError;

        do {
            do {
                startPage();
                try {
                    int menuChoice = scanner.nextInt();
                    if (menuChoice == 1) {
                        createMember();
                    } else if (menuChoice == 2) {
                        editMembers();
                    } else if (menuChoice == 3) {
                        seeMembers();
                    } else if (menuChoice == 4) {
                        searchMembers();
                    } else if (menuChoice == 5) {
                        deleteMembers();
                    } else if (menuChoice == 6) {
                        saveMembers();
                    } else if (menuChoice == 9) {
                        endProgram();
                    }
                    menuError = false;
                } catch (InputMismatchException ime) {
                    System.out.println("Skriv kun tal");
                    scanner.nextLine();
                    menuError = true;
                }
            } while (menuError == true);
        } while (true);
    }

    public void startPage() {
        System.out.println("""
                Tast 1) for oprettelse af nye svømmere.
                Tast 2) for redigering af eksisterende svømmere.
                Tast 3) for udskriving af hele listen.
                Tast 4) for at søge efter svømmer.
                Tast 5) for at slette en svømmer
                Tast 6) for at gemme al information
                Tast 9) for at afslutte.
                """);
    }

    public void createMember() {
        scanner.nextLine();
        System.out.println("Indtast fornavn på nyt medlem");
        String firstName = scanner.nextLine();

        System.out.println("Indtast efternavn");
        String lastName = scanner.nextLine();

        System.out.println("Indtast svømmetype(Motionist eller konkurrencesvømmer)");
        String swimType = scanner.nextLine();

        System.out.println("Indtast alder");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Indtast brugers aktivitet i klubben(a=Aktivt eller p=passivt)");
        boolean membershipStatus = true;
        char activityAnswer;
        do {
            activityAnswer = scanner.nextLine().charAt(0);
            if (activityAnswer == 'a') {
                membershipStatus = true;
                break;
            } else if (activityAnswer == 'p') {
                membershipStatus = false;
                break;
            } else
                System.out.println("Tastefejl, tast aktiv eller passiv");

        } while (activityAnswer != 'a' || activityAnswer != 'p');


        System.out.println("Indtast medlemsnummer");
        int memberShipNumber = Integer.parseInt(scanner.nextLine());

        controller.createMember(firstName, lastName, swimType, age, membershipStatus, memberShipNumber);


    }

    public void editMembers() {

    }

    public void seeMembers() {
        System.out.println("Liste over medlemmer: " + "\n" + "-".repeat(21));
    }

    public void searchMembers() {

    }

    public void deleteMembers() {

    }

    public void saveMembers() {

    }

    public void endProgram() {
        System.out.println("lukker programmet... farvel!");
        System.exit(9);
    }

}
