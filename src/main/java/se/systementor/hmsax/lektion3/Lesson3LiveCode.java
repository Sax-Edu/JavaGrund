package se.systementor.hmsax.lektion3;


import java.util.Scanner;

public class Lesson3LiveCode {

    // Snabbkommandon: psvm +tab för main-metoden, sout +tab för println.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String a = "Hej";

        boolean running = true;

        while (running) {
            System.out.print("Skriv \"Hej\" (eller \"quit\" för att avsluta): ");
            String userInput = scan.nextLine();
            if (userInput.equalsIgnoreCase(a)) {
                System.out.println("Du skrev oerhört rätt!");
            } else if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("Hejdå!");
                running = false;
            } else System.out.println("Nu skrev du fel. :(");
        }
        scan.close();
    }
}
