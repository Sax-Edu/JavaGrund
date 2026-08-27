package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class G1MyndigOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ålder: ");
        int age = scanner.nextInt();

        if (age >= 18) {
            System.out.println("Du är myndig.");
        } else {
            System.out.println("Du är inte myndig.");
        }

        scanner.close();
    }
}
