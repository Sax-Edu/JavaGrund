package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class G8SumOf1ToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange N: ");
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Summan är " + sum + ".");

        scanner.close();
    }
}
