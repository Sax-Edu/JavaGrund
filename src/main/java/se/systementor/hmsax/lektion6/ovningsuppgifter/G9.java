package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.Scanner;

public class G9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (true) {
            System.out.print("Namn: ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Namnet får inte vara tomt.");
            } else {
                break;
            }
        }

        System.out.println("Hej, " + name + "!");
    }
}
