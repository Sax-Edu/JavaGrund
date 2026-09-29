package se.systementor.hmsax.lektion10.ovningsuppgifter.model;

public class Attack {
    private final String name;
    private final int damage;

    public Attack(String name, int damage) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("namn får inte vara tomt");
        }
        if (damage <= 0) {
            throw new IllegalArgumentException("skada måste vara > 0");
        }
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
