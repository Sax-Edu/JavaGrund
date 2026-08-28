package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class VG1PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ett heltal: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false; // Primtal måste vara större än 1
        } else {
            /* Lösningen här med "i * i <= number" blir mycket snabbare för stora tal,
            men "i<number" är också en korrekt lösning. Uppmärksamma "<" istället för "<=".
            Lösning med hjälp av Math-biblioteket är också tillåtet. */
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    isPrime = false; // Hittade en delare, och alltså är number inte ett primtal
                    break;           // Behöver inte leta vidare
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " är ett primtal.");
        } else {
            System.out.println(number + " är inte ett primtal.");
        }
        // alternativ utskrift med ternary operator: System.out.println(isPrime ? n + " är primtal" : n + " är inte primtal");

        scanner.close();
    }
}
