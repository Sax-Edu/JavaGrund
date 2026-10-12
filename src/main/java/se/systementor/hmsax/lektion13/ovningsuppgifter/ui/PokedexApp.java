package se.systementor.hmsax.lektion13.ovningsuppgifter.ui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.systementor.hmsax.lektion13.ovningsuppgifter.model.Pokemon;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PokedexApp {

    private static final String FILE_PATH = "pokedex.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        List<Pokemon> pokedex = loadPokedex(FILE_PATH);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n1) Lägg till 2) Visa 3) Sök 4) Avsluta");
            System.out.print("> ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Namn: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("HP: ");
                    try {
                        int hp = Integer.parseInt(scanner.nextLine().trim());
                        Pokemon p = new Pokemon(name, hp);
                        pokedex.add(p);
                        System.out.println("Tillagd (id " + p.getId().substring(0, 8) + "...).");
                    } catch (NumberFormatException e) {
                        System.out.println("Ogiltigt HP-värde.");
                    }
                }
                case "2" -> {
                    System.out.println("\n--- Alla Pokémons (Sorterade) ---");
                    pokedex.stream()
                            .sorted(Comparator.comparing(Pokemon::getName, String.CASE_INSENSITIVE_ORDER))
                            .forEach(System.out::println);
                }
                case "3" -> {
                    System.out.print("Sök namn: ");
                    String query = scanner.nextLine().trim();
                    pokedex.stream()
                            .filter(p -> p.getName().equalsIgnoreCase(query))
                            .findFirst()
                            .ifPresentOrElse(
                                    p -> System.out.println("Hittad: " + p + " [ID: " + p.getId() + "]"),
                                    () -> System.out.println("Ingen Pokemon hittades med namnet \"" + query + "\".")
                            );
                }
                case "4" -> {
                    savePokedex(FILE_PATH, pokedex);
                    running = false;
                }
                default -> System.out.println("Ogiltigt val.");
            }
        }
    }

    // VG4: Krasch-säker inläsning med try/catch runt Jackson[cite: 20, 24]
    private static List<Pokemon> loadPokedex(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Ingen sparfil hittades. Startar med tom pokédex.");
            return new ArrayList<>();
        }

        try {
            List<Pokemon> list = mapper.readValue(file, new TypeReference<List<Pokemon>>() {});
            System.out.println("Läste in " + list.size() + " pokémons.");
            return new ArrayList<>(list);
        } catch (IOException e) {
            // Fångar både saknade och korrupta filer så appen överlever[cite: 20, 24]
            System.out.println("Sparfilen är skadad. Startar med tomt team.");
            return new ArrayList<>();
        }
    }

    private static void savePokedex(String path, List<Pokemon> pokedex) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), pokedex);
            System.out.println("Sparade " + pokedex.size() + " pokémons till " + path + ". Hej då!");
        } catch (IOException e) {
            System.out.println("Kunde inte spara filen: " + e.getMessage());
        }
    }
}
