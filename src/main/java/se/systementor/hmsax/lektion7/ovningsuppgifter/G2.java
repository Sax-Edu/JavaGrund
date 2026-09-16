package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class G2 {
    public static void main(String[] args) {
        Path path = Path.of("greeting.txt");
        try {
            Files.writeString(path, "Hej, det här är min första fil!");
            System.out.println("Sparat till: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Kunde inte spara filen: " + e.getMessage());
        }
    }
}
