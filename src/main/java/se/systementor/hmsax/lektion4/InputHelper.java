package se.systementor.hmsax.lektion4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {

    public static int readInt(Scanner scanner, String prompt){
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();   // konsumera kvarvarande newline
                return value;
            } catch (InputMismatchException e) { //skydd mot ogiltig inmatning
                System.out.println("Ogiltig input. Skriv ett heltal.");
                scanner.nextLine();   // rensa felaktig input från buffern
            }
        }

    }

    public static int readIntBetween(Scanner scanner, String prompt, int min, int max){
        while (true) {
            int value = readInt(scanner, prompt); //Metoden anropar readInt. readIntBetween blir ett övre skyddslager...
            if (value >= min && value <= max) {   //...som skyddar mot felaktigt värde här.
                return value;
            }
            System.out.printf("Värdet måste vara mellan %d och %d.%n",
                    min, max);
        }

    }
}
