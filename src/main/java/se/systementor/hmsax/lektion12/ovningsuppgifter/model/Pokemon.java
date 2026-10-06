package se.systementor.hmsax.lektion12.ovningsuppgifter.model;

import java.util.ArrayList;
import java.util.List;

// VG5: Implementerar Comparable för sortering på speed
public class Pokemon implements Comparable<Pokemon> {
    private final String name;
    private final int speed;
    private final int maxHp;
    private int currentHp;

    public Pokemon(String name, int speed, int maxHp) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Fel: Namn får inte vara tomt.");
        }
        if (speed < 0 || maxHp <= 0) {
            throw new IllegalArgumentException("Fel: Ogiltigt HP eller Speed.");
        }
        this.name = name;
        this.speed = speed;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
    }

    public String getName() { return name; }
    public int getSpeed() { return speed; }
    public int getCurrentHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }

    public void takeDamage(int damage) {
        this.currentHp = Math.max(0, this.currentHp - damage);
    }

    public void heal(int amount) {
        this.currentHp = Math.min(maxHp, this.currentHp + amount);
    }

    // VG5: Standard interface Comparable
    @Override
    public int compareTo(Pokemon other) {
        return Integer.compare(this.speed, other.speed);
    }

    @Override
    public String toString() {
        return name + " " + speed;
    }
}
