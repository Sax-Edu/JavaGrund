package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VG4 {
    public static void main(String[] args) {
        Path path = Path.of("big.txt");
        int errorCount = 0;

        System.out.println("Läser " + path.getFileName());

        // try-with-resources stänger BufferedReader automatiskt
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ERROR")) {
                    errorCount++;
                }
            }
            System.out.println("Hittade " + errorCount + " rader med \"ERROR\".");
        } catch (IOException e) {
            System.out.println("Fel vid läsning av filen: " + e.getMessage());
        }
    }
}
