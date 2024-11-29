import java.util.Scanner;

public class Poengkalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn karakterene som en string (f.eks. abcde):");
        String input = scanner.nextLine().trim();

        // Splitter inputen basert på komma og fjerner mellomrom
        String[] karakterListe = input.split("");

        int totalPoeng = 0;
        int antallEmner = 0;

        for (String karakter : karakterListe) {
            karakter = karakter.trim().toUpperCase(); // Fjerner mellomrom og gjør til store bokstaver

            int karakterPoeng = karakterTilPoeng(karakter);
            if (karakterPoeng == 0) {
                System.out.println("Ugyldig karakter: " + karakter + ". Hopper over.");
                continue;
            }

            totalPoeng += karakterPoeng * 10; // 10 studiepoeng per emne
            antallEmner++;
        }

        if (antallEmner == 0) {
            System.out.println("Ingen gyldige karakterer ble lagt inn.");
        } else {
            double gjennomsnitt = (double) totalPoeng / (antallEmner * 10);
            System.out.printf("Gjennomsnittlig karakterverdi: %.2f\n", gjennomsnitt);
            if (gjennomsnitt > 25) {
                System.out.println("Master time.");
            }
            else {
                System.out.println("Get your grades up.");
            }
        }

        scanner.close();
    }

    private static int karakterTilPoeng(String karakter) {
        switch (karakter) {
            case "A":
                return 50;
            case "B":
                return 40;
            case "C":
                return 30;
            case "D":
                return 20;
            case "E":
                return 10;
            default:
                return 0; // Ugyldig karakter
        }
    }
}
