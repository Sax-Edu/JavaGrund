package se.systementor.hmsax.lektion10;

import se.systementor.hmsax.lektion9.ovningsuppgifter.Attack;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    public static final int MIN_HP = 0;

    private final String name;
    private final Type type;
    private final int maxHp;
    private int currentHp;
    private List<Attack> attacks; // VG5

    public Pokemon(String name, Type type, int maxHp) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("namn får inte vara tomt");
        }
        if (maxHp <= MIN_HP) {
            throw new IllegalArgumentException("max-HP måste vara > 0");
        }
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attacks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }


    @Override
    public String toString() {
        return name + " (" + type.getLabel() + ", " + currentHp + "/" + maxHp + " HP)";
    }
}
