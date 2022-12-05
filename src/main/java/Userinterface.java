import ENUM.AgeEnums;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Userinterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();

    public void start() {
        controller.createTestData();
        System.out.println("\u001B[1mVelkommen til Delfin svømmeklub\u001B[0m");
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
                    } else if (menuChoice == 8) {
                        showSubscribtions();
                    } else if (menuChoice == 9) {
                        showTeams();
                    } else if (menuChoice == 10) {

                    } else if (menuChoice == 15) {
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

        System.out.println("\u001B[1m1.\u001B[0m Opret medlem");
        System.out.println("\u001B[1m2.\u001B[0m Rediger medlemmer");
        System.out.println("\u001B[1m3.\u001B[0m Udskrivning af medlemmer");
        System.out.println("\u001B[1m4.\u001B[0m Søg efter medlem");
        System.out.println("\u001B[1m5.\u001B[0m Slet medlem");
        System.out.println("\u001B[1m6.\u001B[0m Gem information");
        System.out.println("\u001B[1m7.\u001B[0m Load sidste gem");
        System.out.println("\u001B[1m8.\u001B[0m Kontigentbetaling");
        System.out.println("\u001B[1m9.\u001B[0m Udskrivning af hold");
        System.out.println("\u001B[1m15.\u001B[0m Afslut programmet");
    }

    public void createMember() {
        scanner.nextLine();
        System.out.println("Indtast fornavn på nyt medlem");
        String firstName = scanner.nextLine();

        System.out.println("Indtast efternavn");
        String lastName = scanner.nextLine();

        System.out.println("Indtast svømmetype (m=Motionistsvømmer eller k=konkurrencesvømmer)");
        boolean competitive = true;
        char swimTypeAnswer;
        do {
            swimTypeAnswer = scanner.nextLine().charAt(0);
            if (swimTypeAnswer == 'k') {
                competitive = true;
                break;
            } else if (swimTypeAnswer == 'm') {
                competitive = false;
                break;
            } else
                System.out.println("Tastefejl, tast Motionist eller konkurrencesvømmer");

        } while (swimTypeAnswer != 'm' || swimTypeAnswer != 'k');


        System.out.println("Indtast alder");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Indtast brugers aktivitet i klubben(a=Aktivt eller p=passivt)");
        boolean active = true;
        char activityAnswer;
        do {
            activityAnswer = scanner.nextLine().charAt(0);
            if (activityAnswer == 'a') {
                active = true;
                break;
            } else if (activityAnswer == 'p') {
                active = false;
                break;
            } else
                System.out.println("Tastefejl, tast aktiv eller passiv");

        } while (activityAnswer != 'a' || activityAnswer != 'p');


        System.out.println("Indtast medlemsnummer");
        int membershipNumber = Integer.parseInt(scanner.nextLine());


        controller.createMember(firstName, lastName, competitive, age, active, membershipNumber);
        controller.setJuniorOrSenior();

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


        System.out.println("Svømmetype: " + editMember.isCompetitive());
        String newSwimtype = scanner.nextLine();
        if (!newSwimtype.isEmpty())
            editMember.setCompetitive(Boolean.parseBoolean(newSwimtype));


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

        System.out.println("Medlemsstatus: " + editMember.isActive());
        String newActive = scanner.nextLine();

        if (!newActive.isEmpty()) {
            while (!newActive.equals("p") && !newActive.equals("a")) {
                System.out.println("Fejl. Tast \"a\" eller \"p\". ");
                newActive = scanner.nextLine();

                System.out.println("Medlemsnummer: " + editMember.getMembershipNumber());
                String newMembershipNumber = scanner.nextLine();
                if (!newMembershipNumber.isEmpty())
                    editMember.setMembershipNumber(Integer.parseInt(newMembershipNumber));


            }

            boolean active;
            if (newActive.equals("a")) {
                active = true;
            } else {
                active = false;
            }
            editMember.setActive(active);

            controller.setJuniorOrSenior();

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
                if (member.isCompetitive() == true)
                    System.out.println("Svømmetype: Konkurrencesvømmer");
                else
                    System.out.println("Svømmetype: Motionistsvømmer");
                if (member.isActive() == true)
                    System.out.println("Medlemsstatus: Aktivt");
                else
                    System.out.println("Medlemsstatus: Passivt");
                System.out.println("Alder: " + member.getAge());
                System.out.println("Medlemsnummer: " + member.getMembershipNumber());

                controller.setJuniorOrSenior();
                if (member.isJunior() == true) {
                    System.out.println("Aldersgruppe: Junior");
                } else {
                    System.out.println("Aldersgruppe: Senior");
                }
                System.out.println(" ");
            }

        }
    }

    public void searchMembers() {
        System.out.println("\u001B[1mSøg efter medlemmer\u001B[0m");

        System.out.println("\u001B[1m1.\u001B[0m Søg efter fornavn");
        System.out.println("\u001B[1m2.\u001B[0m Søg efter medlemsnummer");


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
                    if (member.isCompetitive() == true)
                        System.out.println("Svømmetype: Konkurrencesvømmer");
                    else
                        System.out.println("Svømmetype: Motionistsvømmer");
                    if (member.isActive() == true)
                        System.out.println("Medlemsstatus: Aktivt");
                    else
                        System.out.println("Medlemsstatus: Passivt");
                    System.out.println("Alder: " + member.getAge());
                    System.out.println("Medlemsnummer: " + member.getMembershipNumber());
                    if (member.isJunior() == true)
                        System.out.println("Aldersgruppe: Junior");
                    else
                        System.out.println("Aldersgruppe: Senior");
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
                    if (member.isCompetitive() == true)
                        System.out.println("Svømmetype: Konkurrencesvømmer");
                    else
                        System.out.println("Svømmetype: Motionistsvømmer");
                    if (member.isActive() == true)
                        System.out.println("Medlemsstatus: Aktivt");
                    else
                        System.out.println("Medlemsstatus: Passivt");
                    System.out.println("Alder: " + member.getAge());
                    System.out.println("Medlemsnummer: " + member.getMembershipNumber());
                    if (member.isJunior() == true)
                        System.out.println("Aldersgruppe: Junior");
                    else
                        System.out.println("Aldersgruppe: Senior");
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
        System.out.println("Indtastede information er gemt" + "\n");
    }

    public void loadMembers() {
        controller.loadMembers();
        System.out.println("Data loaded");
    }

    public void showSubscribtions() {
        System.out.println("\u001B[1m1.\u001B[0m Liste over kontigentbetalinger");
        System.out.println("\u001B[1m2.\u001B[0m Samlet årlig indkomst");

        int menu = scanner.nextInt();
        if (menu == 1) {
            System.out.println("Kontingent for hvert medlem: ");
            for (Member member : controller.getMembers()) {
                System.out.println(member.getFirstName() + " " + member.getLastName() + ": " + member.getPayment());
            }
            System.out.println("\n");

        } else if (menu == 2) {
            System.out.println("Samlet kontingent for året: " + controller.getTotalPayment() + " kr." + "\n");
        }
    }

    public void showTeams() {
        System.out.println("\u001B[1m1.\u001B[0m Se liste af Seinior");
        System.out.println("\u001B[1m2.\u001B[0m Se liste af junior");

        int menu = scanner.nextInt();
        if (menu == 1) {
            System.out.println("");
            for (Member member : controller.getMembers()) {
                if (member.isJunior()==false) {
                    System.out.println("Træner: "+);
                    System.out.println(member.getFirstName());
                }
            }

        } else if (menu == 2) {
            System.out.println("Konkurrence junior svømmere");
            for (Member member : controller.getMembers()) {

                System.out.println(member.getFirstName() + " " + member.getLastName() + " \n ");

            }
        }
    }

    public void endProgram() {
        System.out.println("Lukker programmet... ");
        System.exit(9);
    }
}
