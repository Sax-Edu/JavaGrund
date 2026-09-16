package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class G7 {
    public static void main(String[] args) {
        Path path = Path.of("does-not-exist.txt");

        try {
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Kunde inte läsa filen: " + path.getFileName() + " finns inte.");
        }

        System.out.println("Programmet avslutas snyggt.");
    }
}
