package se.systementor.hmsax.lektion7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lesson7LiveCode {
    public static void main(String[] args) {

        Path path = Path.of("greeting.txt");

        try {
            if (Files.exists(path)) {
                String data = Files.readString(path);
                System.out.println(data);
            } else {
                System.out.println("Ingen sparad fil ännu.");
            }

            Files.writeString(path, "Hej, fil!\nRad två.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
