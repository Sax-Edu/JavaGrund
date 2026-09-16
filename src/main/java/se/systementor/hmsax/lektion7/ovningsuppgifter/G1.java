package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class G1 {
    public static void main(String[] args) {
        Path path = Path.of("greeting.txt");
        try {
            System.out.println("Sparar hälsning till greeting.txt");
            Files.writeString(path, "Hej, det här är min första fil!");
            System.out.println("Klart! Filen är sparad.");
        } catch (IOException e) {
            System.out.println("Kunde inte spara filen: " + e.getMessage());
        }
    }
}
