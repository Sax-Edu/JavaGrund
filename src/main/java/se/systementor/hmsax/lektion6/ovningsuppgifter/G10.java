package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSum = 0;
        String errorMessage = "Inte ett tal, hoppar över.";

        while (true) {
            System.out.print("Tal (eller 'klar'): ");
            String input = scanner.nextLine().trim();
            if (input == null || input.isEmpty()) {
                System.out.println(errorMessage);
            } else {
                if (input.equalsIgnoreCase("klar")) {
                    break;
                }

                try {
                    int number = Integer.parseInt(input);
                    totalSum += number;
                } catch (NumberFormatException e) {
                    System.out.println(errorMessage);
                }
            }
        }

        System.out.println("Summa: " + totalSum);
    }
}
