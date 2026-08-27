package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Random;
import java.util.Scanner;

public class VG2NumberGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secret = random.nextInt(100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("Jag tänker på ett tal mellan 1 och 100. Gissa!");

        while (guess != secret) {
            System.out.print("Din gissning: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > secret) {
                System.out.println("För högt!");
            } else if (guess < secret) {
                System.out.println("För lågt!");
            } else {
                System.out.println("Rätt! Du klarade det på " + attempts + " gissningar.");
            }
        }

        scanner.close();
    }
}
