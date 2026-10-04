package se.systementor.hmsax.lektion11.ovningsuppgifter.ui;

import se.systementor.hmsax.lektion10.ovningsuppgifter.model.Type;
import se.systementor.hmsax.lektion11.ovningsuppgifter.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== G3: Validering på två nivåer ===");
        try {
            System.out.println("Skapar Thunderbolt (accuracy 100, power 90). OK");
            DamageAttack da1 = new DamageAttack("Thunderbolt", 100, 90);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Skapar Stormhopp (accuracy 150)");
            DamageAttack da2 = new DamageAttack("Stormhopp", 150, 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Skapar Knuff (power 0)");
            DamageAttack da3 = new DamageAttack("Knuff", 100, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== G4 - G7: Anrop av execute() & Polymorfism ===");
        Pokemon charizard = new Pokemon("Charizard", Type.FIRE, 100);
        Pokemon pikachu = new Pokemon("Pikachu", Type.ELECTRIC, 100);

        Attack tackle = new DamageAttack("Tackle", 100, 40);
        Attack thunderbolt = new DamageAttack("Thunderbolt", 100, 90);
        Attack poisonPowder = new StatusAttack("Poison Powder", 75, "förgiftad");

        System.out.println("Charizard HP: " + charizard.getCurrentHp());
        tackle.execute(pikachu, charizard);
        System.out.println("Charizard HP: " + charizard.getCurrentHp());

        thunderbolt.execute(pikachu, charizard);
        System.out.println("Charizard HP: " + charizard.getCurrentHp());

        poisonPowder.execute(pikachu, charizard);

        System.out.println("\n=== G8: Polymorf lista av attacker ===");
        List<Attack> attackList = List.of(thunderbolt, poisonPowder, tackle);
        for (Attack a : attackList) {
            a.execute(pikachu, charizard);
        }

        System.out.println("\n=== G9: is-a vs has-a ===");
        /*
         * (a) DamageAttack IS-A Attack -> Arv (DamageAttack extends Attack)
         * (b) Pokemon HAS-A Type     -> Fält (Pokemon har en Type-variabel)
         * (c) HealAttack IS-A Attack   -> Arv (HealAttack extends Attack)
         */
        Pokemon chansey = new Pokemon("Chansey", Type.NORMAL, 100);
        Attack recover = new HealAttack("Recover", 100, 50);
        recover.execute(chansey, chansey);

        System.out.println("\n=== G10: Pattern matching med instanceof ===");
        for (Attack a : attackList) {
            if (a instanceof DamageAttack d) {
                System.out.println(d.getName() + " (DamageAttack, power " + d.getPower() + ")");
            } else {
                System.out.println(a.getName() + " (status, ingen power)");
            }
        }

        System.out.println("\n=== VG1: Skada med typeffektivitet ===");
        Pokemon glumander = new Pokemon("Glumander", Type.FIRE, 100);
        Pokemon bladis = new Pokemon("Bladis", Type.GRASS, 100);
        Pokemon squirtle = new Pokemon("Squirtle", Type.WATER, 100);

        DamageAttack fireBolt = new DamageAttack("Eldkast", 100, 40, Type.FIRE, false);
        DamageAttack bubble = new DamageAttack("Bubbla", 100, 40, Type.WATER, false);

        fireBolt.execute(glumander, bladis);
        bubble.execute(squirtle, bladis);

        System.out.println("\n=== VG2 & VG5: Krasch-säker stridsrunda ===");
        pikachu.addAttack(thunderbolt);
        pikachu.addAttack(poisonPowder);

        System.out.println("Charizard HP: " + charizard.getCurrentHp());
        System.out.println("> attackIndex: 0");
        pikachu.playTurn(charizard, 0);
        System.out.println("Charizard HP: " + charizard.getCurrentHp());

        System.out.println("> attackIndex: 99");
        pikachu.playTurn(charizard, 99);

        System.out.println("\n=== VG5: Krasch-säker mini-strid ===");
        pikachu.heal(100);
        charizard.heal(100);
        runMiniBattle(pikachu, charizard);
    }

    // VG5: Mini-stridsmotor
    private static void runMiniBattle(Pokemon p1, Pokemon p2) {
        System.out.println("Strid: " + p1.getName() + " vs " + p2.getName());
        int turn = 1;

        // Simulera några turer defensivt
        System.out.println("Tur " + turn + " " + p1.getName() + " attackerar:");
        p1.playTurn(p2, 0);

        System.out.println("> attackIndex: -1");
        p1.playTurn(p2, -1); // Testar felaktigt index

        turn++;
        System.out.println("Tur " + turn + " " + p2.getName() + " attackerar:");
        p2.playTurn(p1, 0);

        if (p1.isFainted()) {
            System.out.println(p2.getName() + " vinner!");
        } else if (p2.isFainted()) {
            System.out.println(p1.getName() + " vinner!");
        }
    }
}