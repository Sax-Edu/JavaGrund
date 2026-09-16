package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VG5 {
    private static final Path PATH = Path.of("contacts.csv");

    public static void main(String[] args) {
        List<String[]> contacts = loadContacts();
        if (!contacts.isEmpty()) {
            System.out.println("Laddade " + contacts.size() + " " + getContactOrContacts(contacts) + " från contacts.csv.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("\n1) Visa 2) Lägg till 3) Avsluta\nVal: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println("--- Kontakter ---");
                    for (String[] c : contacts) {
                        System.out.println(c[0] + " - " + c[1]);
                    }
                }
                case "2" -> {
                    System.out.print("Namn: ");
                    String name = scanner.nextLine();
                    System.out.print("Telefon: ");
                    String phone = scanner.nextLine();
                    contacts.add(new String[]{name, phone});
                    System.out.println("Kontakt tillagd.");
                }
                case "3" -> {
                    saveContacts(contacts);
                    System.out.println("Sparar " + contacts.size() + " " + getContactOrContacts(contacts) + " till contacts.csv. Hej då!");
                    running = false;
                }
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }

    private static List<String[]> loadContacts() {
        List<String[]> list = new ArrayList<>();
        if (!Files.exists(PATH)) return list;

        try {
            List<String> lines = Files.readAllLines(PATH);
            for (String line : lines) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",", -1);
                if (parts.length == 2) {
                    list.add(parts);
                }
            }
        } catch (IOException e) {
            System.out.println("Kunde inte ladda kontakter: " + e.getMessage());
        }
        return list;
    }

    private static String getContactOrContacts(List<String[]> contacts) {
        return contacts.size() > 1 ? "kontakter" : "kontakt";
    }

    private static void saveContacts(List<String[]> contacts) {
        try (BufferedWriter writer = Files.newBufferedWriter(PATH)) {
            for (String[] c : contacts) {
                writer.write(String.join(",", c));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Kunde inte spara kontakter: " + e.getMessage());
        }
    }
}
