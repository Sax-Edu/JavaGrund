package se.systementor.hmsax.lektion3;

import java.util.Scanner;

public class BmiCalculator2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.print("Kategori: ");

        if (bmi < 18.5) {
            System.out.println("Undervikt");
        } else if (bmi < 25) {
            System.out.println("Normalvikt");
        } else if (bmi < 30) {
            System.out.println("Övervikt");
        } else {
            System.out.println("Obesitas");
        }

        System.out.println("Hälsosamt BMI är mellan 18.5 och 25.");

        scanner.close();
    }
}
