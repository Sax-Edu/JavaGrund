package se.systementor.hmsax.lektion2;

import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange temperatur i Celsius: ");
        double celsius = scanner.nextDouble();
        scanner.nextLine(); // Rensar bufferten

        // Formler: Använd 9.0 / 5.0 så att det blir decimaldivision
        double fahrenheit = celsius * 9.0 / 5.0 + 32;
        double kelvin = celsius + 273.15;

        // Utskrift på en rad med 1 decimal
        System.out.printf("%.1f°C motsvarar %.1f°F och %.1fK%n", celsius, fahrenheit, kelvin);

        scanner.close();
    }
}
