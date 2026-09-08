package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int grade = readNonEmptyInt(scanner, "Betyg (0-100): ");
            try {
                if (isValidGrade(grade)) {
                    System.out.println("Godkänt betyg: " + grade);
                    break;
                } else {
                    System.out.println("Betyget måste vara mellan 0 och 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Betyget måste vara ett heltal.");
            }
        }
    }

    public static int readNonEmptyInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                if (input != null && !input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Betyget måste vara ett heltal");
            }
        }
    }

    public static boolean isValidGrade(int grade) {
        return grade >= 0 && grade <= 100;
    }
}
