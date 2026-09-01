package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Scanner;

public class G9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int betyg = lasInHeltalIIntervall(scanner, "Betyg (1-5): ", 1, 5);
        System.out.println("Tack, du gav betyget " + betyg + ".");
    }

    public static int lasInHeltal(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig input. Skriv ett heltal.");
            }
        }
    }

    public static int lasInHeltalIIntervall(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int tal = lasInHeltal(scanner, prompt);
            if (tal >= min && tal <= max) {
                return tal;
            }
            System.out.println("Värdet måste vara mellan " + min + " och " + max + ".");
        }
    }
}
