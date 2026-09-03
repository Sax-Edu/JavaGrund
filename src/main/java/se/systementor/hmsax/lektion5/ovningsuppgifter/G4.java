package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;

public class G4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Mjölk");
        list.add("Bröd");
        list.add("Ägg");
        list.add("Ost");

        System.out.println("Före: " + joinListItemsWithCommas(list));

        list.set(1, "Fil"); // Byt ut index 1 (plats två)

        System.out.println("Efter: " +joinListItemsWithCommas(list));

        System.out.println("Första varan: " + list.get(0));
    }

    public static String joinListItemsWithCommas(ArrayList<String> list){
        if (list == null || list.isEmpty()) { //skriv defensiv kod!
            return "";
        }
        return String.join(", ", list);
    }

}
