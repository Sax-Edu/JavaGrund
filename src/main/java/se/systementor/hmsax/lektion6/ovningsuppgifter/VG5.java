package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.HashMap;

public class VG5 {
    public static void main(String[] args) {
        String[] rawData = {
                "Alice;42",
                "Bob",
                "Carol;xx",
                "Dan;7",
                ""
        };

        HashMap<String, Integer> validScores = new HashMap<>();
        int successCount = 0;
        int skippedCount = 0;

        int rowCounter = 1; //inte nödvändigt enligt instruktionen

        for (String line : rawData) {
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Hoppar över rad " + rowCounter + ": Tom rad");
                skippedCount++;
                rowCounter++;
                continue;
            }

            String[] parts = line.split(";");
            if (parts.length != 2) {
                System.out.println("Hoppar över rad " + rowCounter + ": '" + line + "' (saknar poäng)");
                skippedCount++;
                rowCounter++;
                continue;
            }

            String name = parts[0].trim();
            try {
                int score = Integer.parseInt(parts[1].trim());
                validScores.put(name, score);
                System.out.println("Läste in: " + name + " = " + score);
                successCount++;
            } catch (NumberFormatException e) {
                System.out.println("Hoppar över rad " + rowCounter + ": '" + line + "' (poäng inte ett tal)");
                skippedCount++;
            }
            rowCounter++;
        }

        System.out.println("Klar: " + successCount + " rader inlästa, " + skippedCount + " överhoppade.");
    }
}
