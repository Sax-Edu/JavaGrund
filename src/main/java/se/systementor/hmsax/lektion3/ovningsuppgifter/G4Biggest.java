package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class G4Biggest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tal 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Tal 2: ");
        int num2 = scanner.nextInt();
        System.out.print("Tal 3: ");
        int num3 = scanner.nextInt();

        int largest = num1;

        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }

        System.out.println("Störst är " + largest + ".");

        scanner.close();
    }
}
