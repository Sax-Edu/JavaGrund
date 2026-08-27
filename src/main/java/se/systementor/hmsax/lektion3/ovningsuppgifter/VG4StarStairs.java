package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class VG4StarStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange höjd: ");
        int height = scanner.nextInt();

        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
