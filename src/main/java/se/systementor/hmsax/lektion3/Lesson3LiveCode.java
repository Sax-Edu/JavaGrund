package se.systementor.hmsax.lektion3;


import java.util.Scanner;

public class Lesson3LiveCode {

    // Snabbkommandon: psvm +tab för main-metoden, sout +tab för println.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = "Hej";
        System.out.print("Skriv \"Hej\": ");
        String userInput = scan.nextLine();
        if (userInput.equals(a)) {
            System.out.println("Du skrev oerhört rätt!");
        } else System.out.println("Nu skrev du fel. :(");
        scan.close();
    }
}
