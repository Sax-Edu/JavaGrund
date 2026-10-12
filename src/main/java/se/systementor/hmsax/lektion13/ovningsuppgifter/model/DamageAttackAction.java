package se.systementor.hmsax.lektion13.ovningsuppgifter.model;

public class DamageAttackAction implements BattleAction {
    private final String name;
    private final int damage;

    public DamageAttackAction(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public String label() { return "DamageAttack (" + name + ")"; }

    @Override
    public void execute(Pokemon user, Pokemon target) {
        target.setHp(Math.max(0, target.getHp() - damage));
    }
}

