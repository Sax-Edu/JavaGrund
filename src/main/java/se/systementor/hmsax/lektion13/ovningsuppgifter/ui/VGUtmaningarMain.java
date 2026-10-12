package se.systementor.hmsax.lektion13.ovningsuppgifter.ui;

import se.systementor.hmsax.lektion13.ovningsuppgifter.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VGUtmaningarMain {

    public static void main(String[] args) {

        System.out.println("=== VG1: Lagstatistik på en gång ===");
        List<Pokemon> team = List.of(
                new Pokemon("Pikachu", 35),
                new Pokemon("Charizard", 78),
                new Pokemon("Bulbasaur", 0),
                new Pokemon("Snorlax", 160)
        );

        long fitCount = team.stream().filter(p -> p.getHp() > 0).count();

        int avgHp = (int) team.stream()
                .filter(p -> p.getHp() > 0)
                .mapToInt(Pokemon::getHp)
                .average()
                .orElse(0);

        String strongest = team.stream()
                .max(Comparator.comparingInt(Pokemon::getHp))
                .map(Pokemon::getName)
                .orElse("Ingen");

        System.out.println("Stridsdugliga: " + fitCount);
        System.out.println("Snitt-HP (stridsdugliga): " + avgHp);
        System.out.println("Starkast: " + strongest);


        System.out.println("\n=== VG2: Kedja ihop sökning och uträkning ===");
        int charizardHp = getHpByName(team, "charizard");
        int gengarHp = getHpByName(team, "gengar");
        System.out.println("HP för \"charizard\": " + charizardHp);
        System.out.println("HP för \"gengar\": " + gengarHp);


        System.out.println("\n=== VG3: Tidsstämplad stridslogg ===");
        List<String> battleLog = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        logWinner(battleLog, "Pikachu", formatter);
        logWinner(battleLog, "Charizard", formatter);
        logWinner(battleLog, "Pikachu", formatter);

        battleLog.forEach(System.out::println);

        System.out.println("\n=== VG5: Gör om loopen till en beskrivning ===");
        List<BattleAction> options1 = List.of(
                new SwitchAction(),
                new DamageAttackAction("Thunderbolt", 90),
                new FleeAction(),
                new DamageAttackAction("Tackle", 40)
        );

        List<BattleAction> options2 = List.of(
                new SwitchAction(),
                new FleeAction()
        );

        System.out.println("Vald: " + selectAggressiveAction(options1).label());
        System.out.println("Vald: " + selectAggressiveAction(options2).label());
    }

    // VG2: Transformera Optional direkt med map() och orElse(-1)
    private static int getHpByName(List<Pokemon> team, String name) {
        return team.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(Pokemon::getHp)
                .orElse(-1);
    }

    // VG3: Tidsstämpling med LocalDateTime
    private static void logWinner(List<String> log, String winner, DateTimeFormatter formatter) {
        String entry = LocalDateTime.now().format(formatter) + " Vinnare: " + winner;
        log.add(entry);
    }

    // VG5: Ersätter for-loop med stream + filter + findFirst + orElse
    private static BattleAction selectAggressiveAction(List<BattleAction> options) {
        return options.stream()
                .filter(a -> a instanceof DamageAttackAction)
                .findFirst()
                .orElse(options.get(0));
    }
}
