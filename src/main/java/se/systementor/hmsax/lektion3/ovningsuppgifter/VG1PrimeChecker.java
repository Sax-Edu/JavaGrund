package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class VG1PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ett heltal: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            // Lösningen här med "i * i <= number" blir mycket snabbare för stora tal, men "i<number" är också en korrekt lösning.
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " är ett primtal.");
        } else {
            System.out.println(number + " är inte ett primtal.");
        }

        scanner.close();
    }
}
