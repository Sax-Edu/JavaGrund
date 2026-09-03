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

        StringBuilder joinedList = new StringBuilder();

        for (String listItem : list) {
            joinedList.append(listItem).append(", ");
        }

        joinedList.setLength(joinedList.length() - 2); //ta bort sista kommatecknet

        System.out.println(joinedList);

        // Alternativ för iteration över listan:
        // list.forEach(item -> joinedList.append(listItem).append(", "));

        String removed = list.remove(2); // Tar bort index 2 (tredje varan: Smör)
        System.out.println("Tog bort: " + removed);

        System.out.println("Listan har " + list.size() + " varor:");
        System.out.println(String.join(", ", list)); //Alternativ till StringBuilder-lösningen
    }
}
