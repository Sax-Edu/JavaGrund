package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class G9 {
    public static void main(String[] args) {
        List<String[]> people = new ArrayList<>();
        people.add(new String[]{"Anna", "Göteborg", "29"});
        people.add(new String[]{"Björn", "Malmö", "41"});
        people.add(new String[]{"Cecilia", "Umeå", "35"});

        Path path = Path.of("people.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String[] person : people) {
                writer.write(String.join(", ", person));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Kunde inte spara till CSV: " + e.getMessage());
        }
    }
}
