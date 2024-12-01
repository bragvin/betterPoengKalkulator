import java.util.Scanner;

public class poengKalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn karakterene som en string (f.eks. abcde):");
        String input = scanner.nextLine().trim();

        // Splitting input based on no-space
        String[] karakterListe = input.split("");

        int totalPoeng = 0;
        int antallEmner = 0;

        for (String karakter : karakterListe) {
            karakter = karakter.trim().toUpperCase(); // Standarise case and remove spaces

            int karakterPoeng = karakterTilPoeng(karakter);
            if (karakterPoeng == 0) {
                System.out.println("Ugyldig karakter: " + karakter + ". Hopper over.");
                continue;
            }

            totalPoeng += karakterPoeng * 10; // Assumes 10 points per course
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
            else if (gjennomsnitt == 25) {
                System.out.println("Barely OK.");
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
                return 0; // Invalid character
        }
    }
}
