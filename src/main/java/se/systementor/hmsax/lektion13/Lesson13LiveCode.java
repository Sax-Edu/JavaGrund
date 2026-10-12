package se.systementor.hmsax.lektion13;

import se.systementor.hmsax.lektion13.ovningsuppgifter.model.Pokemon;

import java.util.*;

public class Lesson13LiveCode {

    public static void main(String[] args) {
        Random r = new Random();

        List<Pokemon> team = new ArrayList<>();
        boolean crit = r.nextInt(16) == 0;

        System.out.println(crit);

        String id = UUID.randomUUID().toString();

        UUID id2 = UUID.randomUUID();

        System.out.println("ID: " +id);
        System.out.println("ID2: " +id2);

        Pokemon pikachu = new Pokemon("Pikachu", 67);
        Pokemon snorlax = new Pokemon("Snorlax", 100);
        Pokemon psyduck = new Pokemon("Psyduck", 0);

        team.add(snorlax);
        team.add(pikachu);
        team.add(psyduck);

        List<String> namesOfFitToFightPokemon = team.stream()
                .filter(p -> p.getHp() > 0)
                .map(Pokemon::getName)
                .sorted()
                .toList();

        for (String name : namesOfFitToFightPokemon) {
            System.out.println(name);
        }

        Pokemon p = team.stream().filter(pokemon -> pokemon.getHp() == 100).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ingen pokemon"));
        ;

        System.out.println(p.getName() + " har full hälsa.");
    }
}
