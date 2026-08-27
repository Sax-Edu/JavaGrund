package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class VG3AverageValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        double sum = 0;

        while (true) {
            System.out.print("Tal (0 avslutar): ");
            int input = scanner.nextInt();

            if (input == 0) {
                break;
            }

            sum += input;
            count++;
        }

        if (count == 0) {
            System.out.println("Inga tal matades in.");
        } else {
            double average = sum / count;
            System.out.println("Du matade in " + count + " tal. Medelvärdet är " + average + ".");
        }

        scanner.close();
    }
}
