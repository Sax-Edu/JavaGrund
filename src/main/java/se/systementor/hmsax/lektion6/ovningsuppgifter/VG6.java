package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.ArrayList;
import java.util.Scanner;

class InvalidPokemonException extends RuntimeException {
    public InvalidPokemonException(String message) {
        super(message);
    }
}

public class VG6 {
    private static final ArrayList<String[]> pokedex = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- POKÉDEX ---");
            System.out.println("1) Lägg till  2) Sök  3) Visa alla  4) Avsluta");
            String choice = readStringInRange(scanner, "Välj: ", 1, 4);

            if (choice.equals("4")) {
                System.out.println("Avslutar Pokédex.");
                break;
            }

            switch (choice) {
                case "1" -> addPokemonUI(scanner);
                case "2" -> searchPokemonUI(scanner);
                case "3" -> listPokemon();
            }
        }
    }

    private static void addPokemonUI(Scanner scanner) {
        System.out.print("Namn: ");
        String name = scanner.nextLine();
        if (name != null) {
            name = name.trim();
        }

        String hpInput = readNonEmptyString(scanner, "HP: ");

        try {
            int hp = Integer.parseInt(hpInput);
            validatePokemon(name, hp);
            pokedex.add(new String[]{name, String.valueOf(hp)});
            System.out.println("Tillagd: " + name + " (" + hp + " HP)");
        } catch (NumberFormatException e) {
            System.out.println("Avvisad: HP måste vara ett giltigt heltal.");
        } catch (InvalidPokemonException e) {
            System.out.println("Avvisad: " + e.getMessage());
        }
    }

    private static void searchPokemonUI(Scanner scanner) {
        System.out.print("Sök namn: ");
        String name = scanner.nextLine();
        if (name != null) {
            name = name.trim();
        }

        boolean found = false;
        for (String[] entry : pokedex) {
            if (entry[0].equalsIgnoreCase(name)) {
                System.out.println("Hittad: " + entry[0] + " har " + entry[1] + " HP.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Hittade ingen pokemon med namnet " + name + ".");
        }
    }

    private static void listPokemon() {
        if (pokedex.isEmpty()) {
            System.out.println("Pokédexen är tom.");
            return;
        }
        System.out.println("Alla Pokémons:");
        for (String[] entry : pokedex) {
            System.out.println("- " + entry[0] + " (" + entry[1] + " HP)");
        }
    }

    // Hjälpmetod för att kontrollera om en Pokémon redan finns i listan
    private static boolean existsByName(String name) {
        for (String[] entry : pokedex) {
            if (entry[0].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    public static void validatePokemon(String name, int hp) {
        if (name == null || name.isEmpty()) {
            throw new InvalidPokemonException("Namnet får inte vara tomt.");
        }
        if (hp <= 0) {
            throw new InvalidPokemonException("HP måste vara > 0.");
        }
        if (existsByName(name)) {
            throw new InvalidPokemonException("Det finns redan en Pokémon med namnet '" + name + "'.");
        }
    }

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (input != null) {
                input = input.trim();
                if (!input.isEmpty()) {
                    return input;
                }
            }
            System.out.println("Inmatningen får inte vara tom.");
        }
    }

    public static String readStringInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            String input = readNonEmptyString(scanner, prompt);
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return String.valueOf(value);
                }
                System.out.printf("Ange ett tal mellan %d och %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Det där var inget heltal. Försök igen.");
            }
        }
    }
}