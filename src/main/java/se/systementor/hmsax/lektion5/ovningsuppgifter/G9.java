package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.HashSet;

public class G9 {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(); 

        // Lägg till orden (dubbletter filtreras automatiskt bort)
        words.add("hej"); 
        words.add("hej"); 
        words.add("världen"); 
        words.add("hej"); 
        words.add("världen"); 

        System.out.println("Antal unika ord: " + words.size()); 
        System.out.println(words); 
        // Antalet blir 2 eftersom ett HashSet endast sparar unika element.
    }
}
