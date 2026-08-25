package se.systementor.hmsax.lektion2;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Fråga efter namn
        System.out.print("Ange ditt namn: ");
        String namn = scanner.nextLine();

        //Fråga efter vikt i kg
        System.out.print("Ange din vikt (kg): ");
        double vikt = scanner.nextDouble();
        scanner.nextLine(); // Rensar bufferten (sväljer Enter-tryckningen)

        //Fråga efter längd i cm
        System.out.print("Ange din längd (cm): ");
        double langdCm = scanner.nextDouble();
        scanner.nextLine(); // Rensar bufferten (sväljer Enter-tryckningen)

        //Omvandla längd till meter och beräkna BMI
        double langdMeter = langdCm / 100.0;
        double bmi = vikt / (langdMeter * langdMeter);

        //Skriv ut resultatet formaterat med 1 decimal
        System.out.printf("Hej %s, ditt BMI är %.1f%n", namn, bmi);

        scanner.close();
    }
}