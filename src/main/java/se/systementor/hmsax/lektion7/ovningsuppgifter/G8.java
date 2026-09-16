package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class G8 {
    public static void main(String[] args) {
        Path path = Path.of("log.txt");

        try {
            // Files.writeString skriver över hela filen som standard!
            Files.writeString(path, "rad ett");
            Files.writeString(path, "rad två");

            /*
             * OBSERVERAT: "rad ett" försvann och ersattes helt av "rad två".
             * Files.writeString() rensar/skriver över filens befintliga innehåll.
             */
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Fel: " + e.getMessage());
        }
    }
}