package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;
import java.util.Collections;

public class G10 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(); 
        names.add("Cecilia"); 
        names.add("Anna"); 
        names.add("David"); 
        names.add("Bertil"); 
        names.add("Erik"); 

        System.out.println("Före: " + String.join(", ", names)); 

        Collections.sort(names); // Alfabetisk sortering

        System.out.println("Efter: " + String.join(", ", names)); 
    }
}
