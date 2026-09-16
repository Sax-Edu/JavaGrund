package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class G6 {
    public static void main(String[] args) {
        Path path = Path.of("notes.txt");

        if (Files.exists(path)) {
            try {
                String content = Files.readString(path);
                System.out.println("Innehåll: " + content);
            } catch (IOException e) {
                System.out.println("Ett fel uppstod vid läsning.");
            }
        } else {
            System.out.println("Ingen sparad fil ännu – startar tomt.");
        }
    }
}