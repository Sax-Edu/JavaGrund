package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Scanner;

public class G7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tal = {10, 20, 30, 40, 50};

        System.out.print("Vilket index? ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            System.out.println("Värdet är: " + tal[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Det finns inget värde på det indexet.");
        } catch (NumberFormatException e) {
            System.out.println("Ange ett giltigt heltalsindex.");
        }
    }
}