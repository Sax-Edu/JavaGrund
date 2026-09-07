package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSum = 0;

        while (true) {
            String input = readNonEmptyString(scanner, "Tal (eller 'klar'): ");

            if (input.equalsIgnoreCase("klar")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                totalSum += number;
            } catch (NumberFormatException e) {
                System.out.println("Inte ett tal, hoppar över.");
            }
        }

        System.out.println("Summa: " + totalSum);
    }

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input != null && !input.isEmpty()) {
                return input;
            }
            System.out.println("Inte ett tal, hoppar över.");

        }
    }
}
