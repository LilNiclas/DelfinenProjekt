import java.util.Scanner;

public class Userinterface {
    Scanner scanner = new Scanner(System.in);
    public void Start () {
        System.out.println("Velkommen til Delfin svømmeklub");
        boolean menuError;
        /*
        do {
            do {
                startPage();
                try {
                    int menuChoice = scanner.nextInt();
                    if (menuChoice == 1){
                        createSwimmer();
                    }
                }
            }
        }
    }
         */
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
}
