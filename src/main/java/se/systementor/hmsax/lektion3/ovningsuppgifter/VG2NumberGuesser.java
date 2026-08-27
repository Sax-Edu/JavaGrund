package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class VG2NumberGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int secret = (int) (Math.random() * 100) + 1;
        int guesses = 0;
        int guess = 0;

        System.out.println("Jag tänker på ett tal mellan 1 och 100. Gissa!");

        while (guess != secret) {
            System.out.print("Din gissning: ");
            guess = scanner.nextInt();
            guesses++;

            if (guess > secret) {
                System.out.println("För högt!");
            } else if (guess < secret) {
                System.out.println("För lågt!");
            } else {
                System.out.println("Rätt! Du klarade det på " + guesses + " gissningar.");
            }
        }

        scanner.close();
    }
}
