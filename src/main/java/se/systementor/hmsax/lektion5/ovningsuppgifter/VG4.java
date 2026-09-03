package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class VG4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("katt", "hund", "katt", "fisk", "hund", "katt"));
        HashSet<String> seen = new HashSet<>(); 
        HashSet<String> duplicates = new HashSet<>(); 

        for (String word : list) {
            if (seen.contains(word)) {
                duplicates.add(word); 
            }
            seen.add(word);
        }

        System.out.println("Lista: " + list); 
        System.out.println("Dubbletter: " + String.join(", ", duplicates)); 
    }
}
