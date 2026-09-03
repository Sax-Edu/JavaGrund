package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VG2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>(); 

        while (true) {
            System.out.print("Tal: "); 
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("klar")) { 
                break;
            }

            try {
                numbers.add(Integer.parseInt(input)); 
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt tal."); 
            }
        }

        if (numbers.isEmpty()) return;

        // Beräkna Min, Max och Medel utan om-sortering
        int min = Collections.min(numbers); 
        int max = Collections.max(numbers); 
        int sum = 0;
        for (int n : numbers) sum += n;
        double average = (double) sum / numbers.size();

        // Stigande
        Collections.sort(numbers); 
        System.out.println("Stigande: " + numbers); 

        // Fallande
        Collections.sort(numbers, Collections.reverseOrder()); 
        System.out.println("Fallande: " + numbers); 

        System.out.printf("Min: %d, Max: %d, Medel: %.2f\n", min, max, average);
    }
}
