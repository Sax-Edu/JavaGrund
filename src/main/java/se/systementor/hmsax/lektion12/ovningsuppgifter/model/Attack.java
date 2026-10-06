package se.systementor.hmsax.lektion12.ovningsuppgifter.model;

public abstract class Attack {
    private final String name;

    public Attack(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
