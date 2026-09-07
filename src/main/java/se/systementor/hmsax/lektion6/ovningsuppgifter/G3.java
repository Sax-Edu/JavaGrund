package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight = readDouble(scanner, "Vikt (kg): ");
        System.out.println("Registrerad vikt: " + weight + " kg");
    }

    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt tal. Skriv t.ex. 12.5 eller 12,5.");
            }
        }
    }
}
