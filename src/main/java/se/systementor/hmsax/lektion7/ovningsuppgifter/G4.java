package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class G4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Favorit 1: ");
        String f1 = scanner.nextLine();
        System.out.print("Favorit 2: ");
        String f2 = scanner.nextLine();
        System.out.print("Favorit 3: ");
        String f3 = scanner.nextLine();

        Path path = Path.of("favorites.txt");
        String text = f1 + "\n" + f2 + "\n" + f3;

        try {
            Files.writeString(path, text);
            List<String> lines = Files.readAllLines(path);
            System.out.println("\nDina favoriter:");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ". " + lines.get(i));
            }
        } catch (IOException e) {
            System.out.println("Ett fel uppstod: " + e.getMessage());
        }
    }
}