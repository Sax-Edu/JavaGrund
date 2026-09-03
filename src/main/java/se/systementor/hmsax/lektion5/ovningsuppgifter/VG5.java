package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VG5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mening: ");
        String text = scanner.nextLine();

        String[] words = text.toLowerCase().trim().split(" ");
        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            if (counts.containsKey(word)) {
                int nuvarandeAntal = counts.get(word);
                counts.put(word, nuvarandeAntal + 1);
            } else {
                counts.put(word, 1);
            }
        }

        // 1. Skapa en vanlig lista med alla unika ord
        ArrayList<String> unikaOrd = new ArrayList<>(counts.keySet());

        // 2. Sortera ord-listan baserat på vilket ord som har högst antal i mappen
        unikaOrd.sort((ordA, ordB) -> counts.get(ordB) - counts.get(ordA));

        // 3. Skriv ut orden och hämta antalet med .get()
        for (String ord : unikaOrd) {
            System.out.println(ord + ": " + counts.get(ord));
        }
    }

}
