package se.systementor.hmsax.lektion12.ovningsuppgifter.model;

// VG4: Ärver från abstrakt Attack OCH implementerar BattleAction
public class DamageAttack extends Attack implements BattleAction {
    private final int power;

    public DamageAttack(String name, int power) {
        super(name);
        if (power <= 0) {
            throw new IllegalArgumentException("Power måste vara > 0");
        }
        this.power = power;
    }

    public int getPower() { return power; }

    @Override
    public String label() {
        return getName();
    }

    @Override
    public void execute(Pokemon user, Pokemon target) {
        target.takeDamage(power);
        System.out.println("... " + label() + " träffar för " + power + " skada");
    }
}
