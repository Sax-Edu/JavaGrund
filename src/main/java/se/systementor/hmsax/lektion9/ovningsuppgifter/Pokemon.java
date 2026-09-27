package se.systementor.hmsax.lektion9.ovningsuppgifter;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private Type type;
    private int maxHp;
    private int currentHp;
    private List<Attack> attacks; // VG5

    public Pokemon(String name, Type type, int maxHp) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("namn får inte vara tomt");
        }
        if (maxHp <= 0) {
            throw new IllegalArgumentException("max-HP måste vara > 0");
        }
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attacks = new ArrayList<>();
    }

    // Getters (G6)
    public String getName() { return name; }
    public Type getType() { return type; }
    public int getMaxHp() { return maxHp; }
    public int getCurrentHp() { return currentHp; }
    public List<Attack> getAttacks() { return attacks; }

    // VG4: Ta skada
    public void takeDamage(int damage) {
        this.currentHp = Math.max(0, this.currentHp - damage);
    }

    public boolean isFainted() {
        return this.currentHp == 0;
    }

    // VG5: Lägg till attack
    public void addAttack(Attack attack) {
        if (attacks.size() >= 4) {
            System.out.println("En pokémon kan ha högst 4 attacker.");
            return;
        }
        attacks.add(attack);
    }

    // G7: Läsbar utskrift
    @Override
    public String toString() {
        return name + " (" + type + ", " + currentHp + "/" + maxHp + " HP)";
    }
}
