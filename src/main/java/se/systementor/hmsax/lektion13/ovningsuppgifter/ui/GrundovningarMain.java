package se.systementor.hmsax.lektion13.ovningsuppgifter.ui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.systementor.hmsax.lektion13.ovningsuppgifter.model.Pokemon;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GrundovningarMain {

    public static void main(String[] args) {

        List<Pokemon> team = List.of(
                new Pokemon("Pikachu", 35, List.of("Thunderbolt", "Quick Attack")),
                new Pokemon("Charizard", 0, List.of("Flamethrower")),
                new Pokemon("Bulbasaur", 45, List.of("Vine Whip")),
                new Pokemon("Snorlax", 0, List.of("Body Slam"))
        );

        System.out.println("=== G1: Räkna de stridsdugliga ===");
        // Streams: filter + count (ingen egen räknarloop)
        long fitCount = team.stream()
                .filter(p -> p.getHp() > 0)
                .count();
        System.out.println("Stridsdugliga: " + fitCount);


        System.out.println("\n=== G2: Namnen i bokstavsordning ===");
        // Streams: filter -> map -> sorted -> toList
        List<String> sortedNames = team.stream()
                .filter(p -> p.getHp() > 0)
                .map(Pokemon::getName)
                .sorted()
                .toList();
        System.out.println("Stridsdugliga, sorterade: " + String.join(", ", sortedNames));


        System.out.println("\n=== G3: Högsta HP ===");
        // Stream: mapToInt -> max()
        team.stream()
                .mapToInt(Pokemon::getHp)
                .max()
                .ifPresentOrElse(
                        maxHp -> System.out.println("Högsta HP: " + maxHp),
                        () -> System.out.println("Högsta HP: teamet är tomt")
                );


        System.out.println("\n=== G4 & G5: Sökning med Optional & Reservvärde ===");
        searchAndPrint(team, "pikachu");
        searchAndPrint(team, "mewtwo");

        Pokemon p1 = findByName(team, "bulbasaur").orElse(new Pokemon("MissingNo", 1));
        Pokemon p2 = findByName(team, "ditto").orElse(new Pokemon("MissingNo", 1));
        System.out.println("Sök bulbasaur -> Vald: " + p1.getName());
        System.out.println("Sök ditto -> Vald: " + p2.getName());


        System.out.println("\n=== G6: Dagens datum (java.time) ===");
        // java.time med LocalDate
        LocalDate today = LocalDate.now();
        System.out.println("Dagens datum: " + today.format(DateTimeFormatter.ISO_LOCAL_DATE));


        System.out.println("\n=== G7: Kritisk träff (Random) ===");
        // 1 chans på 16 (rng.nextInt(16) == 0)
        Random rng = new Random();
        int base = 20;
        for (int i = 0; i < 5; i++) {
            boolean crit = rng.nextInt(16) == 0;
            int damage = crit ? base * 2 : base;
            if (crit) {
                System.out.println("KRITISK TRÄFF: " + damage + " skada");
            } else {
                System.out.println("Träff: " + damage + " skada");
            }
        }


        System.out.println("\n=== G8: Unikt ID (UUID) ===");
        Pokemon samplePika = new Pokemon("Pikachu", 35);
        System.out.println(samplePika.getName() + " -> " + samplePika.getId());


        System.out.println("\n=== G9 & G10: Spara och läs JSON med Jackson ===");
        File jsonFile = new File("pokemons.json");
        ObjectMapper mapper = new ObjectMapper();

        try {
            // G9: Serialisera till JSON
            List<Pokemon> teamToSave = List.of(
                    new Pokemon("Pikachu", 35, List.of("Thunderbolt", "Quick Attack")),
                    new Pokemon("Bulbasaur", 45, List.of("Vine Whip"))
            );
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, teamToSave);
            System.out.println("Sparade team till pokemons.json");

            // G10: Deserialisera med TypeReference
            List<Pokemon> loadedTeam = mapper.readValue(jsonFile, new TypeReference<List<Pokemon>>() {});
            System.out.println("Läste " + loadedTeam.size() + " pokémons från pokemons.json:");
            loadedTeam.forEach(p -> System.out.println(" - " + p));

        } catch (IOException e) {
            System.out.println("Fel vid filhantering: " + e.getMessage());
        }
    }

    // G4: Returnerar Optional<Pokemon>
    private static Optional<Pokemon> findByName(List<Pokemon> team, String name) {
        return team.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    private static void searchAndPrint(List<Pokemon> team, String name) {
        findByName(team, name).ifPresentOrElse(
                p -> System.out.println("Hittade " + p.getName() + " med " + p.getHp() + " HP."),
                () -> System.out.println("Ingen Pokemon med namnet \"" + name + "\" i teamet.")
        );
    }
}
