package se.systementor.hmsax.lektion10.ovningsuppgifter.model;

public class Pokemon {
    // G8: Konstant för högsta nivå
    public static final int MAX_LEVEL = 100;

    // G9: Statisk räknare för alla skapade pokémons
    private static int totalCreatedCount = 0;

    // G7: Oföränderliga fält (final)
    private final String name;
    private final Type type;
    private final int maxHp;

    // Föränderligt fält
    private int currentHp;

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

        // G9: Öka räknaren vid skapande
        totalCreatedCount++;
    }

    // G1: Getters
    public String getName() { return name; }
    public Type getType() { return type; }
    public int getMaxHp() { return maxHp; }
    public int getCurrentHp() { return currentHp; }

    // G9: Läs den statiska räknaren
    public static int getTotalCreatedCount() {
        return totalCreatedCount;
    }

    // G2: Setter för HP som städar indatan
    public void setCurrentHp(int hp) {
        if (hp < 0) {
            this.currentHp = 0;
        } else if (hp > maxHp) {
            this.currentHp = maxHp;
        } else {
            this.currentHp = hp;
        }
    }

    // G3 & G6: Ta skada
    public void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("Fel: skada kan inte vara negativ.");
            return;
        }
        this.currentHp = Math.max(0, this.currentHp - amount);
    }

    // G4 & G6: Läka
    public void heal(int amount) {
        if (amount < 0) {
            System.out.println("Fel: läkning kan inte vara negativ.");
            return;
        }
        this.currentHp = Math.min(this.maxHp, this.currentHp + amount);
    }

    // G5: Är den besegrad?
    public boolean isFainted() {
        return this.currentHp == 0;
    }

    // VG3: Utför attack mot en annan pokémon
    public void attack(Pokemon target, Attack attack) {
        System.out.println(this.name + " använder " + attack.getName() + " (" + attack.getDamage() + ") på " + target.getName());
        int oldHp = target.getCurrentHp();
        target.takeDamage(attack.getDamage());
        System.out.println(target.getName() + ": " + oldHp + " HP -> " + target.getCurrentHp() + " HP");
    }

    // VG4: Statisk hjälpfunktion som jämför två pokémons
    public static Pokemon getToughest(Pokemon p1, Pokemon p2) {
        if (p1 == null) return p2;
        if (p2 == null) return p1;
        return (p1.getMaxHp() >= p2.getMaxHp()) ? p1 : p2;
    }

    // VG1: Använd svenska etiketten i utskriften
    @Override
    public String toString() {
        return name + " (" + type.getLabel() + ", " + currentHp + " HP)";
    }
}
