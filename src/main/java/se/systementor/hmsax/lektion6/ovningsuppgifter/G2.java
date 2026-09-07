package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tickets = 0;

        while (true) {
            String input = readNonEmptyString(scanner, "Antal biljetter: ");
            try {
                tickets = Integer.parseInt(input);
                if (tickets < 1) {
                    System.out.println("Antalet måste vara minst 1.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Skriv ett heltal.");
            }
        }

        System.out.println("Du köper " + tickets + " biljetter.");
    }

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (input != null) {
                input = input.trim();
                if (!input.isEmpty()) {
                    return input;
                }
            }
            System.out.println("Skriv ett heltal.");
        }
    }
}
