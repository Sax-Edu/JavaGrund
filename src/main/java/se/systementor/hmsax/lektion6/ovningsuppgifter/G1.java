package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        do {
            // Läser in och säkrar valet som en String inom intervallet "1"-"3"
            String choice = readStringInRange(scanner, "Välj (1-3): ", 1, 3);
            if (choice.equals("1")) {
                System.out.println("Hej!");
            } else if (choice.equals("2")) {
                System.out.println("Hejdå!");
            } else if (choice.equals("3")) {
                System.out.println("Avslutar...");
                running = false;
            }
        }while(running);
    }
    // Läser in text och ser till att den inte är null, tom eller enbart bestående av blanksteg
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
            System.out.println("Inmatningen får inte vara tom. Försök igen.");
        }
    }

    // Anropar readNonEmptyString och validerar att strängen representerar ett tal i intervallet
    public static String readStringInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            String input = readNonEmptyString(scanner, prompt);

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return String.valueOf(value); // returnerar valet som en ren String
                }
                System.out.printf("Ange ett tal mellan %d och %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Det där var inget heltal. Försök igen.");
            }
        }
    }
}
