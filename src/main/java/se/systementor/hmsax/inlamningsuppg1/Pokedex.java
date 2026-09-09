package se.systementor.hmsax.inlamningsuppg1;

/*
DENNA KLASS INNEHÅLLER STÖDKOD FÖR INLÄMNINGSUPPGIFT 1
Allt innehåll får lov att användas oförändrat som del av din inlämning.
Allt innehåll är frivilligt att använda. Har du andra/bättre lösningar så använd dem!
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Pokedex {
    private static ArrayList<Pokemon> pokedex = new ArrayList<>();

    public static void main(String[] args) {

    }

    private static void seedData() {
        pokedex.clear();

        Pokemon p1 = new Pokemon("Pikachu", Type.ELECTRIC, 100, 100);
        p1.attacks.add(new Attack("Thunderbolt", 90, 100, Type.ELECTRIC));
        p1.attacks.add(new Attack("Quick Attack", 40, 100, Type.NORMAL));

        Pokemon p2 = new Pokemon("Charmander", Type.FIRE, 95, 95);
        p2.attacks.add(new Attack("Ember", 40, 100, Type.FIRE));

        Pokemon p3 = new Pokemon("Squirtle", Type.WATER, 105, 105);
        p3.attacks.add(new Attack("Water Gun", 40, 100, Type.WATER));

        Pokemon p4 = new Pokemon("Bulbasaur", Type.GRASS, 100, 100);
        p4.attacks.add(new Attack("Vine Whip", 45, 100, Type.GRASS));

        Pokemon p5 = new Pokemon("Eevee", Type.NORMAL, 110, 110);
        p5.attacks.add(new Attack("Tackle", 40, 100, Type.NORMAL));

        Pokemon p6 = new Pokemon("Snorlax", Type.NORMAL, 200, 200);
        p6.attacks.add(new Attack("Body Slam", 85, 100, Type.NORMAL));

        pokedex.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
        System.out.println("Pokédex har återställts till standarddata (6 Pokémons).");
    }
}
