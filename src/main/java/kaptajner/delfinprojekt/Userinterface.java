package kaptajner.delfinprojekt;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Userinterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();

    public void start() {
        controller.createTestData();
        controller.createTestDataCoach();
        controller.createTournamentResultTestData();
        controller.createPracticeResultTestData();
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
                        editMember();
                    } else if (menuChoice == 3) {
                        seeMembers();
                    } else if (menuChoice == 4) {
                        searchMembers();
                    } else if (menuChoice == 5) {
                        deleteMember();
                    } else if (menuChoice == 6) {
                        saveMembers();
                    } else if (menuChoice == 7) {
                        loadMembers();
                    } else if (menuChoice == 8) {
                        seeSubscribtions();
                    } else if (menuChoice == 9) {
                        seeTeams();
                    } else if (menuChoice == 10) {
                        createResult();
                    } else if (menuChoice == 11) {
                        editResult();
                    } else if (menuChoice == 12) {
                        seeResults();
                    } else if (menuChoice == 13) {
                        seeTopFive();
                    } else if (menuChoice == 14) {
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
        System.out.println("\u001B[1m10.\u001B[0m Opret resultat");
        System.out.println("\u001B[1m11.\u001B[0m Rediger resultater");
        System.out.println("\u001B[1m12.\u001B[0m Udskriv resultater");
        System.out.println("\u001B[1m13.\u001B[0m Udskriv top 5 svømmere");
        System.out.println("\u001B[1m14.\u001B[0m Afslut programmet");
    }

    public void createMember() {
        boolean writingError = false;
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
                System.out.println("\u001B[4mTastefejl, tast Motionist eller konkurrencesvømmer\u001B[0m");

        } while (swimTypeAnswer != 'm' || swimTypeAnswer != 'k');


        System.out.println("Indtast alder");
        int age = 0;
        do {
            try {
                age = scanner.nextInt();
                scanner.nextLine();
                writingError = false;
            } catch (InputMismatchException e) {
                System.out.println("\u001B[4mTastefejl, indtast et tal\u001B[0m");
                scanner.nextLine();
                writingError = true;
            }
        } while (writingError == true);


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
                System.out.println("\u001B[4mTastefejl, tast aktiv eller passiv\u001B[0m");

        } while (activityAnswer != 'a' || activityAnswer != 'p');


        System.out.println("Indtast medlemsnummer");
        int membershipNumber = 0;
        do {
            try {
                membershipNumber = scanner.nextInt();
                scanner.nextLine();
                writingError = false;
            } catch (InputMismatchException e) {
                System.out.println("\u001B[4mTastefejl, indtast et tal\u001B[0m");
                scanner.nextLine();
                writingError = true;
            }
        } while (writingError == true);


        controller.createMember(firstName, lastName, competitive, age, active, membershipNumber);
        controller.setJuniorOrSenior();

    }

    public void editMember() {
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
            } catch (IndexOutOfBoundsException ibe) {
                System.out.println("\u001B[4mIndtast et af numrene vist på skærmen!\u001B[0m");
                scanner.nextLine();
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


        System.out.println("Svømmetype: (Skriv motionist eller konkurrence)" + editMember.isCompetitive());
        String newSwimtype = scanner.nextLine();
        if (!newSwimtype.isEmpty()) {
            while (!newSwimtype.equals("motionist") && !newSwimtype.equals("konkurrence")) {
                System.out.println("\u001B[4mFejl. Tast motionist eller konkurrence\u001B[0");
                newSwimtype = scanner.nextLine();
            }
        }

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


        System.out.println("Medlemsstatus: (Skriv aktiv eller passiv)" + editMember.isActive());
        String newActive = scanner.nextLine();
        if (!newActive.isEmpty()) {
            while (!newActive.equals("passiv") && !newActive.equals("aktiv")) {
                System.out.println("\u001B[4mFejl. Tast aktiv eller passiv\u001B[0");
                newActive = scanner.nextLine();
            }

            boolean active;
            if (newActive.equals("aktiv")) {
                active = true;
            } else {
                active = false;
            }
            editMember.setActive(active);


            System.out.println("Medlemsnummer: " + editMember.getMembershipNumber());
            do {
                String newMembershipNumber = scanner.nextLine().trim();
                if (!newMembershipNumber.isEmpty()) {
                    try {
                        editMember.setAge(Integer.parseInt(newMembershipNumber));
                        writingError = false;

                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[4mInput fejl. Indtast tal.\u001B[0m");
                        writingError = true;
                    }
                }
            } while (writingError == true);

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
                    if (member.isCompetitive() == true) {
                        System.out.println("Svømmetype: Konkurrencesvømmer");
                    } else {
                        System.out.println("Svømmetype: Motionistsvømmer");
                    }
                    if (member.isActive() == true) {
                        System.out.println("Medlemsstatus: Aktivt");
                    } else {
                        System.out.println("Medlemsstatus: Passivt");
                    }
                    System.out.println("Alder: " + member.getAge());
                    System.out.println("Medlemsnummer: " + member.getMembershipNumber());
                    if (member.isJunior() == true) {
                        System.out.println("Aldersgruppe: Junior");
                    } else {
                        System.out.println("Aldersgruppe: Senior");
                    }
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
                    if (member.isCompetitive() == true) {
                        System.out.println("Svømmetype: Konkurrencesvømmer");
                    } else {
                        System.out.println("Svømmetype: Motionistsvømmer");
                    }
                    if (member.isActive() == true) {
                        System.out.println("Medlemsstatus: Aktivt");
                    } else {
                        System.out.println("Medlemsstatus: Passivt");
                    }
                    System.out.println("Alder: " + member.getAge());
                    System.out.println("Medlemsnummer: " + member.getMembershipNumber());
                    if (member.isJunior() == true) {
                        System.out.println("Aldersgruppe: Junior");
                    } else {
                        System.out.println("Aldersgruppe: Senior");
                    }
                    System.out.println("");
                }
            }
        }

    }

    public void deleteMember() {
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

    public void seeSubscribtions() {
        System.out.println("\u001B[1m1.\u001B[0m Liste over kontigentbetalinger");
        System.out.println("\u001B[1m2.\u001B[0m Samlet årlig indkomst");

        int menu = scanner.nextInt();
        if (menu == 1) {
            System.out.println("Kontingent for hvert medlem: ");
            for (Member member : controller.getMembers()) {
                System.out.println(member.getFirstName() + " " + member.getLastName() + ": " + member.getPayment());
            }
            System.out.println(" ");

        } else if (menu == 2) {
            System.out.println("Samlet kontingent for året: " + controller.getTotalPayment() + " kr." + "\n");
        }
    }

    public void seeTeams() {
        System.out.println("\u001B[1m1.\u001B[0m Se seniorhold");
        System.out.println("\u001B[1m2.\u001B[0m Se juniorhold");

        int menu = scanner.nextInt();
        if (menu == 1) {
            System.out.println("");
            System.out.println("\u001B[1mTræner:\u001B[0m");

            for (Coach coach : controller.getCoaches()) {
                if (coach.isCoach() == false) {
                    System.out.println(coach.getFirstName() + " " + coach.getLastName());
                }
            }
            System.out.println(" ");
            System.out.println("\u001B[1mSenior svømmere:\u001B[0m");
            for (Member member : controller.getMembers()) {
                controller.setJuniorOrSenior();
                if (member.isJunior() == false) {
                    System.out.println(member.getFirstName() + " \n ");
                }
            }


        } else if (menu == 2) {
            System.out.println("\u001B[1mTræner:\u001B[0m");
            for (Coach coach : controller.getCoaches()) {
                if (coach.isCoach() == true) {
                    System.out.println(coach.getFirstName() + " " + coach.getLastName());
                }
            }
            System.out.println(" ");
            System.out.println("\u001B[1mJunior svømmere:\u001B[0m");
            for (Member member : controller.getMembers()) {
                controller.setJuniorOrSenior();
                if (member.isJunior() == true) {
                    System.out.println(member.getFirstName() + " " + member.getLastName() + " \n ");
                }
            }
        }
    }

    public void createResult() {
        boolean writingError = false;
        System.out.println("\u001B[1m1.\u001B[0m Opret træningsresultater");
        System.out.println("\u001B[1m2.\u001B[0m Opret konkurrenceresultater");
        int menu = scanner.nextInt();
        if (menu == 1) {
            boolean isPractice = true;

            System.out.println("Indtast medlemsnummer:");
            int membershipNumber = 0;
            do {
                try {
                    membershipNumber = scanner.nextInt();
                    scanner.nextLine();
                    writingError = false;
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[4mTastefejl, indtast et tal\u001B[0m");
                    scanner.nextLine();
                    writingError = true;
                }
            } while (writingError == true);

            System.out.println("Indtast træningstid i sekunder:");
            double timeResult = 0;
            do {
                try {
                    timeResult = scanner.nextDouble();
                    scanner.nextLine();
                    writingError = false;
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[4mTastefejl, indtast et tal\u001B[0m");
                    scanner.nextLine();
                    writingError = true;
                }
            } while (writingError == true);


            System.out.println("Indtast disciplin:");
            String disciplin = scanner.nextLine();

            System.out.println("Indtast dato:");
            String date = scanner.nextLine();

            System.out.println("Indtast alder:");
            boolean isJunior;
            int alder;
            alder = scanner.nextInt();
            if (alder < 18) {
                isJunior = true;
            } else {
                isJunior = false;
            }
            controller.createPracticeResult(timeResult, isPractice, disciplin, date, membershipNumber, isJunior);


        } else if (menu == 2) {
            boolean isPractice = false;
            System.out.println("Indtast medlemsnummer:");
            int membershipNumber = 0;
            do {
                try {
                    membershipNumber = scanner.nextInt();
                    scanner.nextLine();
                    writingError = false;
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[4mTastefejl, indtast et tal\u001B[0m");
                    scanner.nextLine();
                    writingError = true;
                }
            } while (writingError == true);

            System.out.println("Indtast konkurrencetid i sekunder:");
            double timeResult = 0;
            do {
                try {
                    timeResult = scanner.nextDouble();
                    scanner.nextLine();
                    writingError = false;
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[4mTastefejl, indtast et tal\u001B[0m");
                    scanner.nextLine();
                    writingError = true;
                }
            } while (writingError == true);

            System.out.println("Indtast disciplin:");
            String disciplin = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Indtast placering:");
            int placement = 0;
            do {
                try {
                    membershipNumber = scanner.nextInt();
                    scanner.nextLine();
                    writingError = false;
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[4mTastefejl, indtast et tal\u001B[0m");
                    scanner.nextLine();
                    writingError = true;
                }
            } while (writingError == true);

            System.out.println("Indtast navn på stævne:");
            String tournamentName = scanner.nextLine();

            System.out.println("indtast dato:");
            String date = scanner.nextLine();
            System.out.println("\n");

            controller.createCompetetiveResult(timeResult, isPractice, placement, disciplin, tournamentName, date, membershipNumber);
        }

    }

    public void editResult() {
        boolean writingError = false;
        System.out.println("\u001B[1m1.\u001B[0m Ændre træningsresultater");
        System.out.println("\u001B[1m2.\u001B[0m Ændre konkurrenceresultater");
        int menu = scanner.nextInt();
        if (menu == 1) {

            System.out.println("Vælg den tid du vil ændre: ");
            for (int i = 0; i < controller.getPracticeResults().size(); i++) {
                System.out.println(i + 1 + ")" + controller.getPracticeResults().get(i));
            }

            System.out.println("Indtast nummeret på den valgte tid: ");
            int number;
            PracticeResult editResult = null;

            do {
                try {
                    number = scanner.nextInt();
                    scanner.nextLine();
                    writingError = false;
                    editResult = controller.getPracticeResults().get(number - 1);
                } catch (InputMismatchException ime) {
                    System.out.println("Skriv kun numre, tak!");
                    scanner.nextLine();
                    writingError = true;
                }
            } while (writingError == true);



            System.out.println("Medlemsnummer: " + editResult.getMembershipNumber());
            do {
                String newMembershipNumber = scanner.nextLine().trim();
                if (!newMembershipNumber.isEmpty()) {
                    try {
                        editResult.setMembershipNumber(Integer.parseInt(newMembershipNumber));
                        writingError = false;

                    } catch (NumberFormatException nfe) {
                        System.out.println("\u001B[4mInput fejl. Indtast tal.\u001B[0m");
                        writingError = true;
                    }
                }
            } while (writingError == true);


            System.out.println("Disciplin: " + editResult.getDiscipline());
            String newDisciplin = scanner.nextLine();
            if (!newDisciplin.isEmpty())
                editResult.setDiscipline(newDisciplin);


            System.out.println("Tid: " + editResult.getResult());
            do {
                String newResult = scanner.nextLine().trim();
                if (!newResult.isEmpty()) {
                    try {
                        editResult.setTimeResult(Integer.parseInt(newResult));
                        writingError = false;

                    } catch (NumberFormatException nfe) {
                        System.out.println("\u001B[4mInput fejl. Indtast tal.\u001B[0m");
                        writingError = true;
                    }
                }
            } while (writingError == true);


            System.out.println("Dato: " + editResult.getDate());
            String newDate = scanner.nextLine();
            if (!newDate.isEmpty())
                editResult.setDate(newDate);

        } else if (menu == 2) {

            System.out.println("Vælg den tid du vil ændre: ");
            for (int i = 0; i < controller.getCompetetiveResults().size(); i++) {
                System.out.println(i + 1 + ")" + controller.getCompetetiveResults().get(i));
            }

            System.out.println("Indtast nummeret på den valgte tid: ");
            int number;
            CompetitiveResult editResult = null;

            do {
                try {
                    number = scanner.nextInt();
                    scanner.nextLine();
                    writingError = false;
                    editResult = controller.getCompetetiveResults().get(number - 1);
                } catch (InputMismatchException ime) {
                    System.out.println("Skriv kun numre, tak!");
                    scanner.nextLine();
                    writingError = true;
                }
            } while (writingError == true);


            System.out.println("Medlemsnummer: " + editResult.getMembershipNumber());
            do {
                String newMembershipNumber = scanner.nextLine().trim();
                if (!newMembershipNumber.isEmpty()) {
                    try {
                        editResult.setMembershipNumber(Integer.parseInt(newMembershipNumber));
                        writingError = false;

                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[4mInput fejl. Indtast tal.\u001B[0m");
                        writingError = true;
                    }
                }
            } while (writingError == true);


            System.out.println("Disciplin: " + editResult.getDiscipline());
            String newDisciplin = scanner.nextLine();
            if (!newDisciplin.isEmpty())
                editResult.setDiscipline(newDisciplin);


            System.out.println("Tid: " + editResult.getResult());
            do {
                String newResult = scanner.nextLine().trim();
                if (!newResult.isEmpty()) {
                    try {
                        editResult.setTimeResult(Integer.parseInt(newResult));
                        writingError = false;

                    } catch (NumberFormatException e) {
                        System.out.println("\u004B[4mInput fejl. Indtast tal.\u001B[0m");
                        writingError = true;
                    }
                }
            } while (writingError == true);


            System.out.println("Placering: " + editResult.getPlacement());
            do {
                String newPlacement = scanner.nextLine().trim();
                if (!newPlacement.isEmpty()) {
                    try {
                        editResult.setTimeResult(Integer.parseInt(newPlacement));
                        writingError = false;

                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[4mInput fejl. Indtast tal.\u001B[0m");
                        writingError = true;
                    }
                }
            } while (writingError == true);


            System.out.println("Dato: " + editResult.getDate());
            String newDate = scanner.nextLine();
            if (!newDate.isEmpty())
                editResult.setDate(newDate);


            System.out.println("Stævnenavn: " + editResult.getTournamentName());
            String newTournamentName = scanner.nextLine();
            if (!newTournamentName.isEmpty())
                editResult.setTournamentName(newTournamentName);


        }
    }

    public void seeResults() {
        System.out.println("\u001B[1m1.\u001B[0m Se træningsresultater");
        System.out.println("\u001B[1m2.\u001B[0m Se konkurrenceresultater");
        int menu = scanner.nextInt();
        if (menu == 1) {
            System.out.println("Træningresultater: " + "\n");
            for (PracticeResult result : controller.getPracticeResults()) {
                System.out.println("Medlemsnummer: " + result.getMembershipNumber());
                System.out.println("Dicsiplin: " + result.getDiscipline());
                System.out.println("Tid: " + result.getResult());
                System.out.println("Dato: " + result.getDate());
                System.out.println("Junior: " + result.isJunior());
                System.out.println(" ");


            }
        } else if (menu == 2) {
            for (CompetitiveResult result : controller.getCompetetiveResults()) {
                System.out.println("Medlemsnummer: " + result.getMembershipNumber());
                System.out.println("Disciplin: " + result.getDiscipline());
                System.out.println("Tid: " + result.getResult());
                System.out.println("Placering: " + result.getPlacement());
                System.out.println("Dato: " + result.getDate());
                System.out.println("Stævnenavn: " + result.getTournamentName());
                System.out.println(" ");


            }

        }

    }

    public ArrayList<PracticeResult> findJuniorResults() {
        ArrayList<PracticeResult> practiceResultsJunior = new ArrayList<>();
        for (PracticeResult result : controller.getPracticeResults()) {
            if (result.isJunior()) {
                practiceResultsJunior.add(result);
            }
        }
        return practiceResultsJunior;
    }

    public ArrayList<PracticeResult> findSeniorResults() {
        ArrayList<PracticeResult> practiceResultsSenior = new ArrayList<>();
        for (PracticeResult result : controller.getPracticeResults()) {
            if (!result.isJunior()) {
                practiceResultsSenior.add(result);
            }
        }
        return practiceResultsSenior;
    }

    public List<PracticeResult> getTopFive(ArrayList<PracticeResult> results) {
        List<PracticeResult> list = results;
        if (results.size() > 5) {
            return list.subList(0, 5);
        }
        return results;
    }

    public void seeTopFive() {
        System.out.println("\u001B[1m1.\u001B[0m Se top 5 svømmere for Junior");
        System.out.println("\u001B[1m2.\u001B[0m Se top 5 svømmere for Senior");
        int menu = scanner.nextInt();
        if (menu == 1) {
            controller.sortTopFive();
            System.out.println("Top 5 juniorsvømmere: " + "\n");

            ArrayList<PracticeResult> juniorResults = findJuniorResults();
            List<PracticeResult> juniorResultsTopFive = getTopFive(juniorResults);

            for (PracticeResult practiceResult : juniorResultsTopFive) {
                System.out.println("Discpline: " + practiceResult.getDiscipline() + "\n" +
                        "Resultat: " + practiceResult.getResult() + "\n" +
                        "Medlemsnummer: " + practiceResult.getMembershipNumber() + "\n");

            }

        } else if (menu == 2) {
            controller.sortTopFive();
            System.out.println("Top 5 seniorsvømmere: " + "\n");

            ArrayList<PracticeResult> seniorResults = findSeniorResults();
            List<PracticeResult> seniorResultsTopFive = getTopFive(seniorResults);

            for (PracticeResult practiceResult : seniorResultsTopFive) {
                System.out.println("Discpline: " + practiceResult.getDiscipline() + "\n" +
                        "Resultat: " + practiceResult.getResult() + "\n" +
                        "Medlemsnummer: " + practiceResult.getMembershipNumber() + "\n");
            }
        }
    }

    public void endProgram() {
        System.out.println("Lukker programmet... ");
        System.exit(9);
    }
}