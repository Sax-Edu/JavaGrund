package se.systementor.hmsax.lektion9.ovningsuppgifter;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- G1 - G5: Constructorer & Validering ---");
        try {
            Pokemon p1 = new Pokemon("Bulbasaur", Type.GRASS, 45);
            System.out.println("OK: " + p1);
        } catch (IllegalArgumentException e) {
            System.out.println("Kunde inte skapa pokémon: " + e.getMessage());
        }

        try {
            Pokemon pBad = new Pokemon("", Type.ELECTRIC, 35);
        } catch (IllegalArgumentException e) {
            System.out.println("Kunde inte skapa pokémon: " + e.getMessage());
        }

        try {
            Pokemon pBad2 = new Pokemon("Charmander", Type.FIRE, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Kunde inte skapa pokémon: " + e.getMessage());
        }

        System.out.println("\n--- G8: Lista av Pokémons ---");
        List<Pokemon> pokedex = new ArrayList<>();
        pokedex.add(new Pokemon("Pikachu", Type.ELECTRIC, 35));
        pokedex.add(new Pokemon("Charizard", Type.FIRE, 78));
        pokedex.add(new Pokemon("Squirtle", Type.WATER, 44));
        pokedex.add(new Pokemon("Bulbasaur", Type.GRASS, 45));
        pokedex.add(new Pokemon("Snorlax", Type.NORMAL, 160));
        pokedex.add(new Pokemon("Onix", Type.GRASS, 35));

        for (int i = 0; i < pokedex.size(); i++) {
            System.out.println((i + 1) + ". " + pokedex.get(i));
        }

        System.out.println("\n--- G9: Filtrera på typ ---");
        System.out.println("Eldtyper i Pokédexen:");
        for (Pokemon p : pokedex) {
            if (p.getType() == Type.FIRE) {
                System.out.println(p);
            }
        }

        System.out.println("\n--- G10: Klassen Attack ---");
        try {
            Attack thunderbolt = new Attack("Thunderbolt", Type.ELECTRIC, 90, 100);
            System.out.println(thunderbolt);
            Attack badAttack = new Attack("SuperHit", Type.NORMAL, 50, 200);
        } catch (IllegalArgumentException e) {
            System.out.println("Kunde inte skapa attack: " + e.getMessage());
        }

        System.out.println("\n--- VG1: Sök i Pokédexen ---");
        searchPokemon(pokedex, "pikachu");
        searchPokemon(pokedex, "mewtwo");
        searchPokemon(pokedex, "");

        System.out.println("\n--- VG2: Statistik ---");
        printStatistics(pokedex);

        System.out.println("\n--- VG3: Referenser och == ---");
        Pokemon a = new Pokemon("Pikachu", Type.ELECTRIC, 35);
        Pokemon b = new Pokemon("Pikachu", Type.ELECTRIC, 35);
        Pokemon c = a;

        System.out.println("a == b -> " + (a == b) + " (två skilda objekt)");
        System.out.println("a == c -> " + (a == c) + " (c pekar på samma objekt som a)");
        c.takeDamage(25);
        System.out.println("efter att HP ändrats via c:");
        System.out.println("a: " + a.getCurrentHp() + " HP");
        System.out.println("c: " + c.getCurrentHp() + " HP (samma objekt ändras tillsammans)");

        System.out.println("\n--- VG4: Ta skada ---");
        Pokemon charizard = new Pokemon("Charizard", Type.FIRE, 78);
        System.out.println(charizard);
        charizard.takeDamage(50);
        System.out.println("tar 50 skada -> " + charizard.getCurrentHp() + "/" + charizard.getMaxHp() + " HP");
        charizard.takeDamage(40);
        System.out.println("tar 40 skada -> " + charizard.getCurrentHp() + "/" + charizard.getMaxHp() + " HP");
        if (charizard.isFainted()) {
            System.out.println(charizard.getName() + " är besegrad!");
        }

        System.out.println("\n--- VG5: Attacker på Pokémon ---");
        Pokemon pika = new Pokemon("Pikachu", Type.ELECTRIC, 35);
        pika.addAttack(new Attack("Thunderbolt", Type.ELECTRIC, 90, 100));
        pika.addAttack(new Attack("Quick Attack", Type.NORMAL, 40, 100));
        System.out.println(pika);
        System.out.println("Attacker:");
        for (Attack atk : pika.getAttacks()) {
            System.out.println("  " + atk);
        }
        System.out.println("Försök lägga till för många attacker:");
        pika.addAttack(new Attack("Iron Tail", Type.NORMAL, 100, 75));
        pika.addAttack(new Attack("Electro Ball", Type.ELECTRIC, 80, 100));
        pika.addAttack(new Attack("Volt Tackle", Type.ELECTRIC, 120, 100)); // Ska förkastas

        System.out.println("\n--- VG6: Bygg Pokédex från textrader ---");
        List<String> rawLines = List.of(
                "Pikachu, ELECTRIC, 35",
                "Charizard, FIRE, 78",
                "Missingno, GHOST, 12",
                "Oddish, GRASS, xx"
        );
        parsePokedexLines(rawLines);
    }

    // Hjälpmetod VG1
    private static void searchPokemon(List<Pokemon> list, String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Du skrev inget namn. Försök igen.");
            return;
        }
        for (Pokemon p : list) {
            if (p.getName().equalsIgnoreCase(input.trim())) {
                System.out.println("Hittad: " + p);
                return;
            }
        }
        System.out.println("Ingen pokémon med det namnet hittades.");
    }

    // Hjälpmetod VG2
    private static void printStatistics(List<Pokemon> list) {
        Map<Type, Integer> typeCounts = new EnumMap<>(Type.class);
        for (Type t : Type.values()) {
            typeCounts.put(t, 0);
        }

        int totalHp = 0;
        for (Pokemon p : list) {
            typeCounts.put(p.getType(), typeCounts.get(p.getType()) + 1);
            totalHp += p.getMaxHp();
        }

        System.out.println("Antal per typ:");
        for (Map.Entry<Type, Integer> entry : typeCounts.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }
        }

        int avgHp = list.isEmpty() ? 0 : Math.round((float) totalHp / list.size());
        System.out.println("Genomsnittlig max-HP: " + avgHp);
    }

    // Hjälpmetod VG6
    private static void parsePokedexLines(List<String> lines) {
        List<Pokemon> loadedPokedex = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length != 3) continue;

            String name = parts[0].trim();
            String typeStr = parts[1].trim();
            String hpStr = parts[2].trim();

            Type type;
            try {
                type = Type.valueOf(typeStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Hoppar över trasig rad: " + line + " (okänd typ)");
                continue;
            }

            int hp;
            try {
                hp = Integer.parseInt(hpStr);
            } catch (NumberFormatException e) {
                System.out.println("Hoppar över trasig rad: " + line + " (HP är inte ett tal)");
                continue;
            }

            try {
                loadedPokedex.add(new Pokemon(name, type, hp));
            } catch (IllegalArgumentException e) {
                System.out.println("Hoppar över trasig rad: " + line + " (" + e.getMessage() + ")");
            }
        }

        System.out.println("\nInläst Pokédex:");
        for (int i = 0; i < loadedPokedex.size(); i++) {
            System.out.println((i + 1) + ". " + loadedPokedex.get(i));
        }
    }
}
