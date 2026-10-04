package se.systementor.hmsax.lektion11.ovningsuppgifter.model;

import se.systementor.hmsax.lektion10.ovningsuppgifter.model.Type;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private final String name;
    private final Type type;
    private final int maxHp;
    private int currentHp;
    private final List<Attack> attacks = new ArrayList<>();

    public Pokemon(String name, Type type, int maxHp) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Fel: namn får inte vara tomt");
        }
        if (maxHp <= 0) {
            throw new IllegalArgumentException("Fel: maxHp måste vara > 0");
        }
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
    }

    public String getName() { return name; }
    public Type getType() { return type; }
    public int getMaxHp() { return maxHp; }
    public int getCurrentHp() { return currentHp; }

    public boolean isFainted() {
        return currentHp <= 0;
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("Fel: skada kan inte vara negativ.");
            return;
        }
        this.currentHp = Math.max(0, this.currentHp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            System.out.println("Fel: läkning kan inte vara negativ.");
            return;
        }
        this.currentHp = Math.min(maxHp, this.currentHp + amount);
    }

    public void addAttack(Attack attack) {
        if (attack == null) return;
        if (attacks.size() >= 4) {
            System.out.println("En pokémon kan ha högst 4 attacker.");
            return;
        }
        attacks.add(attack);
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    // VG2: Utför tur
    public void playTurn(Pokemon defender, int attackIndex) {
        if (this.isFainted()) {
            System.out.println(name + " (" + currentHp + " HP) är besegrad och kan inte attackera.");
            return;
        }
        if (attacks.isEmpty()) {
            System.out.println(name + " har inga attacker att använda!");
            return;
        }
        if (attackIndex < 0 || attackIndex >= attacks.size()) {
            System.out.println("Ogiltigt attackindex. Välj mellan 0 och " + (attacks.size() - 1) + ".");
            return;
        }

        Attack attack = attacks.get(attackIndex);
        attack.executeAttack(this, defender);
    }

    @Override
    public String toString() {
        return name + " (HP " + currentHp + "/" + maxHp + ")";
    }
}