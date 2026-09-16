package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class G3 {
    public static void main(String[] args) {
        Path path = Path.of("greeting.txt");
        try {
            String content = Files.readString(path);
            System.out.println("Innehåll i greeting.txt:");
            System.out.print(content);
        } catch (IOException e) {
            System.out.println("Kunde inte läsa filen: " + e.getMessage());
        }
    }
}
