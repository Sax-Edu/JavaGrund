package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Scanner;

public class VG6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int antal = lasInPositivtHeltal(scanner, "Hur många tal? ");
        double[] talArray = new double[antal];

        for (int i = 0; i < antal; i++) {
            talArray[i] = lasInDouble(scanner, "Tal " + (i + 1) + ": ");
        }

        double medel = beraknaMedelvarde(talArray);
        System.out.println("Medelvärde: " + medel);
    }

    public static int lasInPositivtHeltal(Scanner scanner, String ledtext) {
        while (true) {
            System.out.print(ledtext);
            try {
                int tal = Integer.parseInt(scanner.nextLine());
                if (tal > 0) {
                    return tal;
                }
                System.out.println("Ange ett tal större än 0.");
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig input. Skriv ett heltal.");
            }
        }
    }

    public static double lasInDouble(Scanner scanner, String ledtext) {
        while (true) {
            System.out.print(ledtext);
            try {
                return Double.parseDouble(scanner.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig input. Skriv ett heltal.");
            }
        }
    }

    public static double beraknaMedelvarde(double[] tal) {
        double summa = 0;
        for (double t : tal) {
            summa += t;
        }
        return summa / tal.length;
    }
}
