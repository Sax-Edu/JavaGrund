package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class VG5MinMaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE; //Övningen går fint att lösa utan denna konstant, men det är ett smidigt verktyg.
        int max = Integer.MIN_VALUE; //Övningen går fint att lösa utan denna konstant, men det är ett smidigt verktyg.

        while (true) {
            System.out.print("Tal (0 avslutar): ");
            int input = scanner.nextInt();

            if (input == 0) {
                break;
            }

            if (input < min) {
                min = input;
            }
            if (input > max) {
                max = input;
            }

            sum += input;
            count++;
        }

        if (count == 0) {
            System.out.println("Inga tal matades in.");
        } else {
            System.out.println("Minst: " + min);
            System.out.println("Störst: " + max);
            System.out.println("Summa: " + sum);
        }

        scanner.close();
    }
}

/*
LÖSNING UTAN INTEGER-KONSTANTER

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int sum = 0;
        int min = 0;
        int max = 0;

        while (true) {
            System.out.print("Tal (0 avslutar): ");
            int input = scanner.nextInt();

            if (input == 0) {
                break;
            }

            // Om det är det allra första talet, sätter vi det som startvärde för min och max
            if (count == 0) {
                min = input;
                max = input;
            } else {
                if (input < min) {
                    min = input;
                }
                if (input > max) {
                    max = input;
                }
            }

            sum += input;
            count++;
        }

        if (count == 0) {
            System.out.println("Inga tal matades in.");
        } else {
            System.out.println("Minst: " + min);
            System.out.println("Störst: " + max);
            System.out.println("Summa: " + sum);
        }

        scanner.close();
    }
 */