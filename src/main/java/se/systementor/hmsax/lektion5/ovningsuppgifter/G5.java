package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;
import java.util.Scanner;

public class G5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(); 
        list.add("Mjölk");
        list.add("Fil");
        list.add("Ägg");
        list.add("Ost");

        System.out.print("Sök vara: "); 
        String search = scanner.nextLine().trim(); //trim tar bort blanksteg

        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) { 
            if (list.get(i).equalsIgnoreCase(search)) { // Ignorerar stora/små bokstäver
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Ja, " + list.get(foundIndex).toLowerCase() + " finns på plats " + (foundIndex + 1) + ".");
        } else {
            System.out.println("Nej, " + search.toLowerCase() + " finns inte i listan.");
        }
    }
}
