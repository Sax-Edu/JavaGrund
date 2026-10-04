package se.systementor.hmsax.lektion11.ovningsuppgifter.model;

public abstract class Attack {
    private final String name;
    private final int accuracy;

    public Attack(String name, int accuracy) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Fel: namn får inte vara tomt");
        }
        // G3: Validering av accuracy (0-100)
        if (accuracy < 0 || accuracy > 100) {
            throw new IllegalArgumentException("Fel: accuracy maste vara 0-100");
        }
        this.name = name;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public int getAccuracy() {
        return accuracy;
    }

    // G5 & G6: Abstrakt metod som tvingar subklasser att definiera sitt beteende,
    // men basklassen tillhandahåller logg-funktionen via sin egen execute-kropp.
    public void executeAttack(Pokemon attacker, Pokemon defender) {
        System.out.print(attacker.getName() + " anvander " + name + "! ");
    }
}
