import java.util.ArrayList;
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
                    } else if (menuChoice == 7) {
                        loadMembers();
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
                Tast 1) for oprettelse af nye medlemmer.
                Tast 2) for redigering af eksisterende medlemmer.
                Tast 3) for udskriving af hele listen.
                Tast 4) for at søge efter medlemmer.
                Tast 5) for at slette en medlemmer.
                Tast 6) for at gemme medlemmer i systemet.
                Tast 7) for at load medlemmer.
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


        //Membershipagrgroup
        boolean membershipAgeGroup = controller.setJuniorOrSenior();

        controller.createMember(firstName, lastName, swimType, age, membershipStatus, memberShipNumber, membershipAgeGroup);


    }

    public void editMembers() {
        boolean writingError;

        System.out.println("Vælg det medlem du vil redigere: ");

        for (int i = 0; i < controller.getMembers().size(); i++) {
            System.out.println(i + 1 + ")" + controller.getMembers().get(i));
        }

        System.out.println("Indtast nummeret på det valgte medlem: ");
        int number;
        Member editMember = null;
        do {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                writingError = false;
                editMember = controller.getMembers().get(number - 1);
            } catch (InputMismatchException ime) {
                System.out.println("Skriv kun numre, tak!");
                scanner.nextLine();
                writingError = true;

            } catch (IndexOutOfBoundsException ibe) {
                System.out.println("Indtast kun numre du kan se!");
                writingError = true;
            }
        } while (writingError == true);


        System.out.println("Redigere medlemsinformation: " + editMember);
        System.out.println("Indskriv ny data. Vil du ikke redigere tryk Enter.");

        System.out.println("Fornavn: " + editMember.getFirstName());
        String newName = scanner.nextLine();
        if (!newName.isEmpty())
            editMember.setFirstName(newName);


        System.out.println("Efternavn: " + editMember.getLastName());
        String newLName = scanner.nextLine();
        if (!newLName.isEmpty())
            editMember.setLastName(newLName);


        System.out.println("Svømmetype: " + editMember.getSwimType());
        String newSwimtype = scanner.nextLine();
        if (!newSwimtype.isEmpty())
            editMember.setSwimType(newSwimtype);


        System.out.println("Alder: " + editMember.getAge());
        do {
            String newAge = scanner.nextLine().trim();
            if (!newAge.isEmpty()) {
                try {
                    editMember.setAge(Integer.parseInt(newAge));
                    writingError = false;

                } catch (NumberFormatException nfe) {
                    System.out.println("\u001B[4mInput fejl. Indtast tal.\u001B[0m");
                    writingError = true;
                }
            }
        } while (writingError == true);

        System.out.println("Medlemsstatus: " + editMember.isMembershipStatus());
        String newMembershipStatus = scanner.nextLine();

        if (!newMembershipStatus.isEmpty()) {
            while (!newMembershipStatus.equals("p") && !newMembershipStatus.equals("a")) {
                System.out.println("Fejl. Tast \"a\" eller \"p\". ");
                newMembershipStatus = scanner.nextLine();

        System.out.println("Medlemsnummer: " + editMember.getMembershipNumber());
        String newMembershipNumber = scanner.nextLine();
        if (!newMembershipNumber.isEmpty())
            editMember.setMembershipNumber(Integer.parseInt(newMembershipNumber));


            }

            boolean membershipStatus;
            if (newMembershipStatus.equals("a")) {
                membershipStatus = true;
            } else {
                membershipStatus = false;
            }
            editMember.setMembershipStatus(membershipStatus);

        }

        System.out.println("Juniormedlem eller Seniormedlem: " + editMember.isMembershipAgeGroup());
        String newMembershipAgeGroup = scanner.nextLine();

        if (!newMembershipAgeGroup.isEmpty()) {
            while (!newMembershipAgeGroup.equals("j") && !newMembershipAgeGroup.equals("s")) {
                System.out.println("Fejl, indtast \"j\" for junior, \"s\" for senior. ");
                newMembershipAgeGroup = scanner.nextLine();

                boolean membershipAgeGroup;
                if (newMembershipAgeGroup.equals("j")) {
                    membershipAgeGroup = true;
                } else {
                    membershipAgeGroup = false;
                }
                editMember.setMembershipAgeGroup(membershipAgeGroup);


            }
        }

    }

    public void seeMembers() {
        System.out.println("\u001B[1mRegistreret medlemmer\u001B[0m");

        if (controller.getMembers().isEmpty()) {
            System.out.println("\u001B[4mIngen medlemmer fundet\u001B[0m");
            System.out.println("");
        } else {
            for (Member member : controller.getMembers()) {
                System.out.println("Navn: " + member.getFirstName());
                System.out.println("Efternavn: " + member.getLastName());
                System.out.println("Svømmetype: " + member.getSwimType());
                if (member.isMembershipStatus() == true)
                    System.out.println("Er medlem aktiv: Ja");
                else
                    System.out.println("Er medlem aktiv: Nej");
                System.out.println("Alder: " + member.getAge());
                System.out.println("Medlemsnummer: " + member.getMembershipNumber());
                System.out.println("");
            }
        }
    }

    public void searchMembers() {
        System.out.println("\u001B[1mSøg efter medlemmer\u001B[0m");

        System.out.println("""
                Tast 1) for at søge efter medlem ved fornavn.
                Tast 2) for at søge efter medlem ved medlemsnummer.
                """);
        int menu = scanner.nextInt();

        if (menu == 1) {
            System.out.print("Indtast fornavn: ");
            scanner.nextLine();
            String searchTerm = scanner.nextLine();
            System.out.println("");

            ArrayList<Member> searchResult = controller.searchMembersFirstName(searchTerm);

            if (searchResult.isEmpty()) {
                System.out.println("\u001B[4mIngen medlemmer fundet\u001B[0m");
                System.out.println("");
            } else {
                System.out.println("\u001B[1mMedlemmer fundet\u001B[0m");
                for (Member member : searchResult) {
                    System.out.println("Navn: " + member.getFirstName());
                    System.out.println("Efternavn: " + member.getLastName());
                    System.out.println("Svømmetype: " + member.getSwimType());
                    if (member.isMembershipStatus() == true)
                        System.out.println("Er medlem aktiv: Ja");
                    else
                        System.out.println("Er medlem aktiv: Nej");
                    System.out.println("Alder: " + member.getAge());
                    System.out.println("Medlemsnummer: " + member.getMembershipNumber());
                    System.out.println("");
                }
            }
        } else if (menu == 2) {
            System.out.print("Indtast medlemsnummer: ");
            int searchNumber = scanner.nextInt();
            System.out.println("");

            ArrayList<Member> searchResult = controller.searchMembersMembershipNumber(searchNumber);

            if (searchResult.isEmpty()) {
                System.out.println("\u001B[4mIngen medlemmer fundet\u001B[0m");
                System.out.println("");
            } else {
                System.out.println("\u001B[1mMedlemmer fundet\u001B[0m");
                for (Member member : searchResult) {
                    System.out.println("Navn: " + member.getFirstName());
                    System.out.println("Efternavn: " + member.getLastName());
                    System.out.println("Svømmetype: " + member.getSwimType());
                    if (member.isMembershipStatus() == true)
                        System.out.println("Er medlem aktiv: Ja");
                    else
                        System.out.println("Er medlem aktiv: Nej");
                    System.out.println("Alder: " + member.getAge());
                    System.out.println("Medlemsnummer: " + member.getMembershipNumber());
                    System.out.println("");
                }
            }
        }
    }

    public void deleteMembers() {
        boolean delete = false;
        System.out.println("\u001B[1mFjern medlemmer fra klubben\u001B[0m");
        for (int i = 0; i < controller.getMembers().size(); i++)
            System.out.println(i + 1 + ": " + controller.getMembers().get(i));

        System.out.println("Indtast nummeret tilsvarende til medlemmet der skal fjerens");
        int number = scanner.nextInt();
        scanner.nextLine();

        Member deleteMember = controller.getMembers().get(number - 1);
        controller.deleteMember(deleteMember);
        System.out.println("Det udvalgte medlem er fjernet fra databasen");
    }

    public void saveMembers() {
        controller.saveMembers();
        System.out.println("Indtastede information er gemt");
    }

    public void loadMembers () {
        controller.loadMembers();
        System.out.println("Data loaded");
    }

    public void endProgram() {
        System.out.println("lukker programmet... farvel!");
        System.exit(9);
    }
}