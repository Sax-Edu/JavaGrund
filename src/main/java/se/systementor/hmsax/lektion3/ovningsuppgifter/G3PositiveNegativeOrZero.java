package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class G3PositiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ett tal: ");
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println("Positivt");
        } else if (number < 0) {
            System.out.println("Negativt");
        } else {
            System.out.println("Noll");
        }

        scanner.close();
    }
}
