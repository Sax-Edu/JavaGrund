package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Scanner;

public class VG5Input {
    //notera att vi inte har någon main-metod här. Denna klass innehåller hjälpmetoder men är inget eget program.
    public static int lasInInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig input. Skriv ett heltal.");
            }
        }
    }

    public static int lasInIntIIntervall(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int tal = lasInInt(scanner, prompt);
            if (tal >= min && tal <= max) {
                return tal;
            }
            System.out.println("Värdet måste vara mellan " + min + " och " + max + ".");
        }
    }

    public static double lasInDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig input. Skriv ett tal.");
            }
        }
    }
}
