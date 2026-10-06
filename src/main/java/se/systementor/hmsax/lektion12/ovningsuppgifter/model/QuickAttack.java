package se.systementor.hmsax.lektion12.ovningsuppgifter.model;

public class QuickAttack extends DamageAttack {
    public QuickAttack(String name, int power) {
        super(name, power);
    }

    // G6: Överskrider default-metoden från BattleAction
    @Override
    public boolean consumesTurn() {
        return false;
    }
}
