package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Random;
import java.util.Scanner;

public class VG1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            skrivUtMeny();
            int val = lasInHeltalIIntervall(scanner, "Välj: ", 1, 4);

            switch (val) {
                case 1 -> halsa(scanner);
                case 2 -> räknaBmi(scanner);
                case 3 -> slumpaTal();
                case 4 -> {
                    System.out.println("Avslutar...");
                    running = false;
                }
            }
            System.out.println();
        }
    }

    public static void skrivUtMeny() {
        System.out.println("=== Meny ===");
        System.out.println("1. Hälsa");
        System.out.println("2. Räkna BMI");
        System.out.println("3. Slumpa tal");
        System.out.println("4. Avsluta");
    }

    public static int lasInHeltal(Scanner scanner, String ledtext) {
        while (true) {
            System.out.print(ledtext);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig input. Skriv ett heltal.");
            }
        }
    }

    public static int lasInHeltalIIntervall(Scanner scanner, String ledtext, int min, int max) {
        while (true) {
            int tal = lasInHeltal(scanner, ledtext);
            if (tal >= min && tal <= max) {
                return tal;
            }
            System.out.println("Välj mellan " + min + " och " + max + ".");
        }
    }

    public static void halsa(Scanner scanner) {
        System.out.print("Vad heter du? ");
        String namn = scanner.nextLine();
        System.out.println("Hej " + namn + "!");
    }

    public static void räknaBmi(Scanner scanner) {
        System.out.print("Vikt (kg): ");
        double vikt = Double.parseDouble(scanner.nextLine());
        System.out.print("Längd (cm): ");
        double langd = Double.parseDouble(scanner.nextLine()) / 100;
        System.out.printf("BMI: %.1f\n", (vikt / (langd * langd)));
    }

    public static void slumpaTal() {
        Random rand = new Random();
        System.out.println("Slumptal: " + (rand.nextInt(100) + 1));
    }
}