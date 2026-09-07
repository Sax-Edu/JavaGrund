package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        do {
            double numerator = readNonEmptyNumber(scanner, "Täljare: ");
            double denominator = readNonEmptyNumber(scanner, "Nämnare: ");

            if (denominator == 0) {
                System.out.println("Kan inte dela med noll.");
            } else {
                double result = numerator / denominator;
                System.out.println("Resultat: " + result);
                running = false;
            }
        } while (running);
    }

    public static double readNonEmptyNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double number = Double.parseDouble(input);
                if (input != null && !input.isEmpty()) {
                        return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Det där var inget tal.");
            }
        }
    }

}
