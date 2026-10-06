package se.systementor.hmsax.lektion12.ovningsuppgifter.ui;

import se.systementor.hmsax.lektion12.ovningsuppgifter.model.*;
import se.systementor.hmsax.lektion12.ovningsuppgifter.player.CpuPlayer;
import se.systementor.hmsax.lektion12.ovningsuppgifter.strategy.AggressiveStrategy;
import se.systementor.hmsax.lektion12.ovningsuppgifter.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pokemon glumanda = new Pokemon("Glumanda", 65, 100);
        Pokemon pikachu = new Pokemon("Pikachu", 90, 100);

        System.out.println("=== G1: BattleAction Kontrakt ===");
        BattleAction tackle = new DamageAttack("Tackle", 20);
        System.out.println("Drag: " + tackle.label());
        System.out.println("Glumanda HP: " + glumanda.getCurrentHp());
        tackle.execute(pikachu, glumanda);
        System.out.println("Glumanda HP: " + glumanda.getCurrentHp());

        /*
         * G2: Om man tar bort t.ex. label() eller execute() ur DamageAttack
         * ger kompilatorn ett fel som säger:
         * "DamageAttack is not abstract and does not override abstract method label() in BattleAction"
         * Detta för att alla icke-abstrakta klasser måste implementera alla metoder i interfacet.
         */

        System.out.println("\n=== G3 & G4: Polymorfism via interface ===");
        BattleAction actionVar;
        actionVar = new DamageAttack("Tackle", 20);
        actionVar.execute(pikachu, glumanda);

        actionVar = new FleeAction();
        actionVar.execute(pikachu, glumanda);

        System.out.println("\n=== G5 & G10: Menyhantering utan krasch ===");
        List<BattleAction> menuActions = List.of(
                new DamageAttack("Tackle", 20),
                new DamageAttack("Ember", 40),
                new ItemAction("Potion", 20), // G10: Ny actiontyp utan ändring i menyn!
                new FleeAction()
        );
        runMenuDemo(menuActions, pikachu, glumanda);

        System.out.println("\n=== G6: Default-metod ===");
        BattleAction flee = new FleeAction();
        BattleAction quick = new QuickAttack("QuickAttack", 10);
        System.out.println("Fly tar en hel tur: " + flee.consumesTurn());
        System.out.println("QuickAttack tar en hel tur: " + quick.consumesTurn());

        System.out.println("\n=== G7: Multi-interface (Describable) ===");
        if (flee instanceof Describable d) {
            System.out.println("Meny: " + flee.label());
            System.out.println("Beskrivning: " + d.getDescription());
        }

        System.out.println("\n=== G8 & G9 & VG1: Strategy pattern ===");
        List<BattleAction> cpuActions = List.of(new FleeAction(), new DamageAttack("Ember", 40));
        CpuPlayer randCpu = new CpuPlayer(new RandomStrategy());
        CpuPlayer aggroCpu = new CpuPlayer(new AggressiveStrategy());

        System.out.println("[Random] CPU valde: " + randCpu.selectAction(cpuActions, glumanda, pikachu).label());
        System.out.println("[Aggressive] CPU valde: " + aggroCpu.selectAction(cpuActions, glumanda, pikachu).label());

        System.out.println("\n=== VG5: Sortering med Comparable ===");
        List<Pokemon> team = new ArrayList<>(List.of(
                new Pokemon("Snorlax", 30, 100),
                new Pokemon("Pikachu", 90, 100),
                new Pokemon("Glumanda", 65, 100)
        ));
        System.out.println("Före: " + team);
        Collections.sort(team); // Använder inbyggda compareTo()
        System.out.println("Efter: " + team);

        /*
         * VG4 Förklaring:
         * Attack är en *abstrakt klass* eftersom alla attacker delar gemensamt TILLSTÅND (fältet `name`).
         * BattleAction är ett *interface* eftersom det beskriver ett KONTRAKT / BETEENDE som även helt
         * olika typer av objekt (t.ex. FleeAction eller ItemAction) kan implementera utan att dela kod.
         */
    }

    // G5: Krasch-säker menyloopp
    private static void runMenuDemo(List<BattleAction> actions, Pokemon user, Pokemon target) {
        System.out.println("Välj drag:");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println((i + 1) + ". " + actions.get(i).label());
        }

        Scanner scanner = new Scanner("abc\n2\n"); // Fejkar input "abc" sedan "2"
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            System.out.println("> " + input);
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= actions.size()) {
                    actions.get(choice - 1).execute(user, target);
                    break;
                } else {
                    System.out.println("Ogiltigt val. Skriv ett nummer mellan 1 och " + actions.size() + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt val. Skriv ett nummer mellan 1 och " + actions.size() + ".");
            }
        }
    }
}
