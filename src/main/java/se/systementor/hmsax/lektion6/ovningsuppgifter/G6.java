package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30};

        System.out.print("Position (0-2): ");
        String posInput = scanner.nextLine().trim();

        System.out.print("Tal: ");
        String valInput = scanner.nextLine().trim();

        try {
            int index = Integer.parseInt(posInput);
            int element = numbers[index]; // Kan kasta ArrayIndexOutOfBoundsException
            int value = Integer.parseInt(valInput); // Kan kasta NumberFormatException

            System.out.println("Hämtat tal: " + element + ", Tolkat tal: " + value);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Fel i indatan: kontrollera position och tal.");
        }
    }
}
