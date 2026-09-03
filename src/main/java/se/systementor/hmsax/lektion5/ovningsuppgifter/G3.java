package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;

public class G3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); 
        list.add("Mjölk"); 
        list.add("Bröd"); 
        list.add("Smör"); 
        list.add("Ägg"); 
        list.add("Ost"); 

        System.out.println("Listan har " + list.size() + " varor:");

        for(String listItem : list){
            System.out.print(listItem +", ");
        }

        System.out.println();

        // Alternativ för iteration över listan:
        // list.forEach(item -> System.out.print(item + ", "));

        String removed = list.remove(2); // Tar bort index 2 (tredje varan: Smör)
        System.out.println("Tog bort: " + removed); 

        System.out.println("Listan har " + list.size() + " varor:"); 
        System.out.println(String.join(", ", list)); 
    }
}
