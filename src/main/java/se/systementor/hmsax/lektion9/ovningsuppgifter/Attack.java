package se.systementor.hmsax.lektion9.ovningsuppgifter;

public class Attack {
    private String name;
    private Type type;
    private int baseDamage;
    private int accuracy; // 0-100

    public Attack(String name, Type type, int baseDamage, int accuracy) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("namn får inte vara tomt");
        }
        if (baseDamage <= 0) {
            throw new IllegalArgumentException("basskada måste vara > 0");
        }
        if (accuracy < 0 || accuracy > 100) {
            throw new IllegalArgumentException("träffsäkerhet måste vara 0-100");
        }
        this.name = name;
        this.type = type;
        this.baseDamage = baseDamage;
        this.accuracy = accuracy;
    }

    public String getName() { return name; }
    public Type getType() { return type; }
    public int getBaseDamage() { return baseDamage; }
    public int getAccuracy() { return accuracy; }

    @Override
    public String toString() {
        return name + " (" + type + ", " + baseDamage + " skada, " + accuracy + "% träff)";
    }
}
