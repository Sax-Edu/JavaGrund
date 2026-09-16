package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class G10 {
    public static void main(String[] args) {
        Path path = Path.of("people.csv");
        List<String[]> people = new ArrayList<>();

        if (Files.exists(path)) {
            try {
                List<String> lines = Files.readAllLines(path);
                for (String line : lines) {
                    if (!line.isBlank()) {
                        String[] person = line.split(", ");
                        people.add(person);
                    }
                }
            } catch (IOException e) {
                System.out.println("Kunde inte läsa CSV: " + e.getMessage());
            }
        }

        System.out.println("Laddade " + people.size() + " personer:");
        for (String[] p : people) {
            System.out.println("- " + p[0] + " (" + p[1] + ", " + p[2] + " år)");
        }
    }
}
