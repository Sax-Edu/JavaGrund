package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VG3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of("journal.txt");
        List<String> logbook = new ArrayList<>();

        if (Files.exists(path)) {
            try {
                logbook = Files.readAllLines(path);
            } catch (IOException e) {
                System.out.println("Kunde inte läsa journalen.");
            }
        }

        System.out.print("Skriv dagens rad: ");
        String entry = scanner.nextLine();
        logbook.add(entry);

        try {
            Files.writeString(path, String.join("\n", logbook));
        } catch (IOException e) {
            System.out.println("Kunde inte spara journalen.");
        }

        System.out.println("\nHela loggboken:");
        for (int i = 0; i < logbook.size(); i++) {
            System.out.println((i + 1) + ". " + logbook.get(i));
        }
    }
}
