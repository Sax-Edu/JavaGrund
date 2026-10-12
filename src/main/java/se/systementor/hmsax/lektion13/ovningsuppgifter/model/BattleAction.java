package se.systementor.hmsax.lektion13.ovningsuppgifter.model;

public interface BattleAction {
    String label();
    void execute(Pokemon user, Pokemon target);
}
