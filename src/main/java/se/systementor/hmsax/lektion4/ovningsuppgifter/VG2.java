package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Scanner;

public class VG2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celsius = lasInDouble(scanner, "Grader Celsius: ");
        double fahrenheit = celsius * 1.8 + 32;

        System.out.println(celsius + " grC");
        System.out.println(fahrenheit + " grF");
    }

    public static double lasInDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().replace(',', '.'); //om man vill tillåta kommatecken
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig input. Skriv ett tal.");
            }
        }
    }
}
