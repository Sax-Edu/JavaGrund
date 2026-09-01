package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Scanner;

public class G10BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange ditt namn: ");
        String name = scanner.nextLine();

        double vikt = readDouble(scanner, "Ange din vikt (kg): ");

        double langdCm = readDouble(scanner, "Ange din längd (cm): ");

        double bmi = calculateBmi(vikt, langdCm);

        String category = getBmiCategory(bmi);

        printResult(name, bmi, category);

        scanner.close();
    }

    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig input. Skriv ett heltal.");
            }
        }
    }


    public static double calculateBmi(double vikt, double langdCm) {
        double langdM = langdCm / 100.0;
        return vikt / (langdM * langdM);
    }

    public static String getBmiCategory(double bmi) {
        if (bmi < 18.5) {
            return "undervikt";
        } else if (bmi < 25.0) {
            return "normalvikt";
        } else if (bmi < 3.0) {
            return "övervikt";
        } else {
            return "obesitas";
        }
    }

    public static void printResult(String name, double bmi, String kategori) {
        System.out.printf("Hej %s, ditt BMI är %.1f (%s).\n",name, bmi, kategori);
    }
}
