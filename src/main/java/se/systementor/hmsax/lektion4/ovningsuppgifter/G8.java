package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Scanner;

public class G8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int alder = lasInHeltal(scanner, "Hur gammal är du? ");
        System.out.println("Du angav: " + alder);
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
}
