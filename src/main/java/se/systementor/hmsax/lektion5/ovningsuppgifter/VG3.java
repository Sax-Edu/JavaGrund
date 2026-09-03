package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.HashMap;

public class VG3 {
    public static void main(String[] args) {
        HashMap<String, Integer> phonebook = new HashMap<>();
        phonebook.put("Anna", 28);
        phonebook.put("Bertil", 41);
        phonebook.put("Cecilia", 35);
        phonebook.put("David", 52);

        // Sätt 1: Både namn (nyckel) och ålder (värde) samtidigt med forEach
        System.out.println("--- Sätt 1: Både namn och ålder samtidigt ---");
        phonebook.forEach((namn, alder) -> {
            System.out.println(namn + " -> " + alder);
        });

        // Sätt 2: Hämtar först alla namn (keySet) och slår sedan upp åldern
        System.out.println("\n--- Sätt 2: Först alla namn ---");
        for (String namn : phonebook.keySet()) {
            int alder = phonebook.get(namn);
            System.out.println(namn + " -> " + alder);
        }
    }
}
