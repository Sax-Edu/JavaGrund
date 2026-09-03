package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.HashMap;
import java.util.Scanner;

public class G7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> phonebook = new HashMap<>(); 

        phonebook.put("Anna", 28); 
        phonebook.put("Bertil", 41); 
        phonebook.put("Cecilia", 35); 
        phonebook.put("David", 52); 

        System.out.print("Namn: "); 
        String name = scanner.nextLine();

        if (phonebook.containsKey(name)) { 
            System.out.println(name + " är " + phonebook.get(name) + " år."); 
        }
    }
}
