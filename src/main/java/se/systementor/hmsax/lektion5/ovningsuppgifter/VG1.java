package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.HashMap;
import java.util.Scanner;

public class VG1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mening: "); 
        String text = scanner.nextLine();

        String[] words = text.toLowerCase().trim().split(" "); // Dela upp i ord och gör till små bokstäver
        HashMap<String, Integer> counts = new HashMap<>();

        // Går igenom varje ord i arrayen och uppdaterar antalet förekomster i HashMapen
        for (String word : words) {
            if (counts.containsKey(word)) {
                int nuvarandeAntal = counts.get(word);
                counts.put(word, nuvarandeAntal + 1); // Öka med 1 om det finns
            } else {
                counts.put(word, 1);                  // Lägg till med 1 om det är nytt
            }
        }

        // Går igenom alla unika ord i HashMapen och skriver ut ordet tillsammans med dess antal
        for (String word : counts.keySet()) { 
            System.out.println(word + ": " + counts.get(word)); 
        }
    }
}
