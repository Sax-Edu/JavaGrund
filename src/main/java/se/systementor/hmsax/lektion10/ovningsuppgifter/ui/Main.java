package se.systementor.hmsax.lektion10.ovningsuppgifter.ui;

import se.systementor.hmsax.lektion10.ovningsuppgifter.model.Attack;
import se.systementor.hmsax.lektion10.ovningsuppgifter.model.Pokemon;
import se.systementor.hmsax.lektion10.ovningsuppgifter.model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- G8 & G9: Statiska medlemmar ---");
        System.out.println("Högsta nivå (utan att skapa nåt objekt): " + Pokemon.MAX_LEVEL);

        Pokemon pikachu = new Pokemon("Pikachu", Type.ELECTRIC, 35);
        Pokemon charizard = new Pokemon("Charizard", Type.FIRE, 78);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", Type.GRASS, 100);

        System.out.println("Antal skapade pokémon: " + Pokemon.getTotalCreatedCount());

        System.out.println("\n--- G1 - G4: Encapsulation, Setter, Skada & Läka ---");
        System.out.println("Namn: " + pikachu.getName());
        System.out.println("HP: " + pikachu.getCurrentHp());

        System.out.println("Försöker sätta HP = -50");
        pikachu.setCurrentHp(-50);
        System.out.println("HP blir: " + pikachu.getCurrentHp());

        System.out.println("Försöker sätta HP = 9999");
        pikachu.setCurrentHp(9999);
        System.out.println("HP blir: " + pikachu.getCurrentHp());

        pikachu.takeDamage(20);
        System.out.println("tar 20 skada -> " + pikachu.getCurrentHp() + " HP");

        pikachu.heal(100);
        System.out.println("läker 100 -> " + pikachu.getCurrentHp() + " HP");

        System.out.println("\n--- G5 & G6: Besegrad och negativ skada ---");
        pikachu.setCurrentHp(15);
        System.out.println("Pikachu (15 HP) besegrad? " + pikachu.isFainted());
        pikachu.takeDamage(15);
        System.out.println("Pikachu (0 HP) besegrad? " + pikachu.isFainted());

        System.out.println("Försöker ta -10 skada...");
        pikachu.takeDamage(-10);

        System.out.println("\n--- G7: Slutgiltigt (final) ---");
        // pikachu.name = "Raichu"; // BORTKOMMENTERAT: Kompilerar ej pga final-fält!

        System.out.println("\n--- G10, VG1, VG2: Enums med etiketter & egenskaper ---");
        for (Type t : Type.values()) {
            String category = t.isSpecial() ? "special" : "vanlig";
            System.out.println(t + " -> " + t.getLabel() + ": " + category);
        }

        System.out.println("\nUtskrift med svenska etiketter:");
        System.out.println(pikachu);
        System.out.println(charizard);

        System.out.println("\n--- VG3: Använda klassen Attack ---");
        Attack flamethrower = new Attack("Flamethrower", 90);
        charizard.attack(bulbasaur, flamethrower);

        System.out.println("\n--- VG4: Tåligast av två ---");
        Pokemon toughest = Pokemon.getToughest(charizard, pikachu);
        System.out.println(charizard.getName() + " (" + charizard.getMaxHp() + " HP) vs " + pikachu.getName() + " (" + pikachu.getMaxHp() + " HP)");
        System.out.println("Tåligast: " + toughest.getName());

        System.out.println("\n--- VG6: Pokédex-sökning ---");
        List<Pokemon> dex = List.of(
                new Pokemon("Pikachu", Type.ELECTRIC, 35),
                new Pokemon("Charizard", Type.FIRE, 78),
                new Pokemon("Squirtle", Type.WATER, 44)
        );

        searchPokedex(dex, "pikachu");
        searchPokedex(dex, "mewtwo");
        searchPokedex(dex, "");
    }

    // VG6: Sökmetod för Pokédex
    private static void searchPokedex(List<Pokemon> dex, String search) {
        System.out.print("Sök pokémon: " + search + "\n");
        if (search == null || search.trim().isEmpty()) {
            System.out.println("Ange ett namn.");
            return;
        }

        for (Pokemon p : dex) {
            if (p.getName().equalsIgnoreCase(search.trim())) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Hittade ingen pokémon med namnet \"" + search + "\".");
    }
}