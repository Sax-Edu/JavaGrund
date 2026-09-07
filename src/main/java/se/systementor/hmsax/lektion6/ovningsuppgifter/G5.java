package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tal: ");
        String input = scanner.nextLine();

        try {
            int val = Integer.parseInt(input);
            System.out.println("Dubbla värdet: " + (val * 2));
        } catch (NumberFormatException e) {
            System.out.println("Det där var inget tal.");
        }
        System.out.println("Bearbetning klar.");

    }
}
