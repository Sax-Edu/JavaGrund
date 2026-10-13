package se.systementor.hmsax.lektion14.ovningsuppgifter;

import java.util.List;

public class Pokemon {
    private String name;
    private Type type;
    private int hp;
    private List<String> attacks;

    public Pokemon(String name, Type type, int hp, List<String> attacks) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Namn får inte vara tomt.");
        }
        if (hp <= 0) {
            throw new IllegalArgumentException("HP måste vara större än 0.");
        }
        if (attacks != null && attacks.size() > 4) {
            throw new IllegalArgumentException("Kan inte ha fler än 4 attacker.");
        }

        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attacks = attacks;
    }
}
