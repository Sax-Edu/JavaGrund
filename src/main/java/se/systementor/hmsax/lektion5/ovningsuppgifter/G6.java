package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;
import java.util.Scanner;

public class G6 {
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
                int num = Integer.parseInt(input); // Krasch-säker konvertering
                numbers.add(num); 
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt tal. Försök igen."); 
            }
        }

        int sum = 0;
        for (int n : numbers) { 
            sum += n;
        }

        System.out.println("Du matade in " + numbers.size() + " tal. Summa: " + sum); 
    }
}
