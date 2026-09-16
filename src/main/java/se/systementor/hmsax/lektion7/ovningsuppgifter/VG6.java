package se.systementor.hmsax.lektion7.ovningsuppgifter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VG6 {

    public static void save(Path path, List<String[]> pokemons) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String[] p : pokemons) {
                writer.write(String.join(",", p));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Kunde inte spara: " + e.getMessage());
        }
    }

    public static List<String[]> load(Path path) {
        List<String[]> result = new ArrayList<>();
        if (!Files.exists(path)) {
            System.out.println("Ingen sparad pokedex hittades startar tom.");
            return result;
        }

        int badRows = 0;
        try {
            for (String line : Files.readAllLines(path)) {
                if (line.isBlank()) {
                    badRows++;
                    continue;
                }
                String[] f = line.split(",", -1);
                if (f.length != 3) {
                    badRows++; // Hoppa korrupt rad
                    continue;
                }
                result.add(f);
            }
        } catch (IOException e) {
            System.out.println("Kunde inte ladda: " + e.getMessage());
        }

        if (badRows > 0) {
            System.out.println("Laddade " + result.size() + " pokémons (" + badRows + " trasig rad hoppades över):");
        } else {
            System.out.println("Laddade " + result.size() + " pokémons:");
        }

        return result;
    }

    public static void main(String[] args) {
        Path path = Path.of("pokedex.csv");

        // Ladda vid start
        List<String[]> pokedex = load(path);

        // Skriv ut laddat innehåll
        for (String[] p : pokedex) {
            System.out.println("- " + p[0] + " (" + p[1] + ", " + p[2] + " HP)");
        }

        //lägg till och spara
        pokedex.add(new String[]{"Pikachu", "Electric","45"});
        save(path, pokedex);
    }
}