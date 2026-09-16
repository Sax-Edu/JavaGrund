package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VG1 {
    public static void main(String[] args) {
        Path path = Path.of("people.csv");
        List<String[]> people = new ArrayList<>();
        int skippedRows = 0;

        if (Files.exists(path)) {
            try {
                List<String> lines = Files.readAllLines(path);
                for (String line : lines) {
                    String trimmedLine = line.trim(); //trimma bort blanksteg i början/slutet av raden

                    if (trimmedLine.isBlank()) {
                        skippedRows++;
                        continue;
                    }

                    // Ta bort ett eventuellt avslutande kommatecken
                    if (trimmedLine.endsWith(",")) {
                        trimmedLine = trimmedLine.substring(0, trimmedLine.length() - 1).trim();
                    }

                    // Dela upp raden på kommatecken
                    String[] rawParts = trimmedLine.split(",");

                    // Kräver exakt 3 fält (Namn, Stad, Ålder)
                    if (rawParts.length != 3) {
                        skippedRows++;
                        continue;
                    }

                    // Trimma varje enskilt fält från extra blanksteg
                    String name = rawParts[0].trim();
                    String city = rawParts[1].trim();
                    String ageStr = rawParts[2].trim();

                    // Kontrollera att åldern är ett giltigt tal samt validera att fälten inte är tomma
                    try {
                        Integer.parseInt(ageStr);
                        if (name.isEmpty() || city.isEmpty()) {
                            skippedRows++;
                            continue;
                        }
                        people.add(new String[]{name, city, ageStr});
                    } catch (NumberFormatException e) {
                        skippedRows++; // Ålder var inget giltigt tal
                    }
                }
            } catch (IOException e) {
                System.out.println("Fel vid läsning: " + e.getMessage());
            }
        }

        System.out.println("Laddade " + people.size() + " personer (hoppade " + skippedRows + " trasiga rader):");
        for (String[] p : people) {
            System.out.println("- " + p[0] + " (" + p[1] + ", " + p[2] + " år)");
        }
    }
}