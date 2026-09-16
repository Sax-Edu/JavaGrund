package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VG2 {
    public static void main(String[] args) {
        Path path = Path.of("count.txt");
        int count = 0;

        if (Files.exists(path)) {
            try {
                String text = Files.readString(path).trim();
                count = Integer.parseInt(text);
            } catch (IOException | NumberFormatException e) {
                count = 0;
            }
        }

        count++;
        System.out.println("Det här är körning nummer " + count + ".");

        try {
            Files.writeString(path, String.valueOf(count));
        } catch (IOException e) {
            System.out.println("Kunde inte spara räknaren: " + e.getMessage());
        }
    }
}
