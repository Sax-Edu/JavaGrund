package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Random;
import java.util.Scanner;

public class VG6MenuLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;

        while (running) {
            System.out.println("=== Meny ==="); //Menyns 5 rader kan även placeras innan loopen. Hur blir detta för UX?
            System.out.println("1. Hälsa");
            System.out.println("2. Räkna BMI");
            System.out.println("3. Slumpa tal");
            System.out.println("4. Avsluta");

            System.out.print("Välj: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Ange namn: ");
                    String name = scanner.next();
                    System.out.println("Hej " + name + "!");
                }
                case 2 -> {
                    System.out.print("Ange ditt namn: ");
                    String namn = scanner.nextLine();

                    System.out.print("Ange din vikt (kg): ");
                    double vikt = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ange din längd (cm): ");
                    double langdCm = scanner.nextDouble();
                    scanner.nextLine();

                    double langdMeter = langdCm / 100.0;
                    double bmi = vikt / (langdMeter * langdMeter);

                    System.out.printf("Hej %s, ditt BMI är %.1f%n", namn, bmi);
                }
                case 3 -> {
                    int randomNumber = random.nextInt(100) + 1;  //alternativ: int randomNumber = (int) (Math.random() * 100) + 1;
                    System.out.println("Slumpat tal: " + randomNumber);
                }
                case 4 -> {
                    System.out.println("Hej då!");
                    running = false;
                }
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        scanner.close();
    }
}
