package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class G2OddOrEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ett heltal: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " är jämnt.");
        } else {
            System.out.println(number + " är udda.");
        }

        scanner.close();
    }
}
