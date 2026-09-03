package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.HashMap;
import java.util.Map;

public class VG3 {
    public static void main(String[] args) {
        HashMap<String, Integer> phonebook = new HashMap<>();
        phonebook.put("Anna", 28);
        phonebook.put("Bertil", 41);
        phonebook.put("Cecilia", 35);
        phonebook.put("David", 52);

        // Sätt 1: Både namn (nyckel) och ålder (värde) samtidigt med forEach
        for (Map.Entry<String, Integer> entry : phonebook.entrySet()) {
            String name = entry.getKey();
            int age = entry.getValue();
            System.out.println(name + " -> " + age);
        }


        // Sätt 2: Hämtar först alla namn (keySet) och slår sedan upp åldern
        System.out.println("\n--- Sätt 2: Först alla namn ---");
        for (String namn : phonebook.keySet()) {
            int alder = phonebook.get(namn);
            System.out.println(namn + " -> " + alder);
        }
    }
}
