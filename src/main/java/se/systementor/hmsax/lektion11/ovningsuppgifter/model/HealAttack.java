package se.systementor.hmsax.lektion11.ovningsuppgifter.model;

public class HealAttack extends Attack {
    private final int healAmount;

    public HealAttack(String name, int accuracy, int healAmount) {
        super(name, accuracy);
        if (healAmount <= 0) {
            throw new IllegalArgumentException("Fel: healAmount måste vara > 0");
        }
        this.healAmount = healAmount;
    }

    @Override
    public void execute(Pokemon attacker, Pokemon defender) {
        super.execute(attacker, defender);
        attacker.heal(healAmount);
        System.out.println(attacker.getName() + " återstaller " + healAmount + " HP.");
    }
}
