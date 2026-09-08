package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class VG3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1) Addera 2) Subtrahera 3) Dividera 4) Avsluta");
            String choice = readStringInRange(scanner, "Välj: ", 1, 4);

            if (choice.equals("4")) {
                System.out.println("Hejdå!");
                break;
            }

            double num1 = readDouble(scanner, "Första talet: ");
            double num2 = readDouble(scanner, "Andra talet: ");

            switch (choice) {
                case "1" -> System.out.println("Summa: " + (num1 + num2));
                case "2" -> System.out.println("Differens: " + (num1 - num2));
                case "3" -> {
                    if (num2 == 0) {
                        System.out.println("Kan inte dela med noll.");
                    } else {
                        System.out.println("Kvot: " + (num1 / num2));
                    }
                }
            }
        }
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
            System.out.println("Inmatningen får inte vara tom.");
        }
    }

    public static String readStringInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            String input = readNonEmptyString(scanner, prompt);
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return String.valueOf(value);
                }
                System.out.printf("Ange ett tal mellan %d och %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Det där var inget heltal. Försök igen.");
            }
        }
    }

    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            String input = readNonEmptyString(scanner, prompt).replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt tal. Skriv t.ex. 12.5 eller 12,5.");
            }
        }
    }
}
