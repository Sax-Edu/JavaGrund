package se.systementor.hmsax.lektion2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mata in ett heltal: ");
        int a = scanner.nextInt();
        scanner.nextLine(); // Rensar bufferten

        System.out.print("Mata in ytterligare ett heltal: ");
        int b = scanner.nextInt();
        scanner.nextLine(); // Rensar bufferten

        // Beräkningar
        int summa = a + b;
        int differens = a - b;
        int produkt = a * b;
        double kvot = (double) a / b; // Casting till double för att inte tappa decimaler
        int rest = a % b;            // Modulo-operatorn ger resten vid division

        // Utskrift
        System.out.println("Summa:     " + summa);
        System.out.println("Differens: " + differens);
        System.out.println("Produkt:   " + produkt);
        System.out.printf("Kvot:      %.2f%n", kvot);
        System.out.println("Rest:      " + rest);

        scanner.close();
    }
}