package se.systementor.hmsax.lektion2;

import java.util.Scanner;

public class ScannerPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vad heter du i förnamn? ");
        String firstName = scanner.nextLine();
        System.out.println("Hej " + firstName + "!");
        /*
        System.out.print("Din ålder: ");
        int age = scanner.nextInt();
        scanner.nextLine(); //Viktig! Konsumerar kvarvarande line efter int.
        System.out.print("Ditt efternamn: ");
        String lastName = scanner.nextLine();
        System.out.println("Hej " + firstName + " " + lastName + ", du är " + age + " år.");
        */
        scanner.close();
    }
}
