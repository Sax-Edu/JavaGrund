package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class G5 {
    public static void main(String[] args) {
        Path path = Path.of("varor.txt"); // Skapad för hand i editorn
        try {
            List<String> lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }
        } catch (IOException e) {
            System.out.println("Kunde inte läsa filen: " + e.getMessage());
        }
    }
}
