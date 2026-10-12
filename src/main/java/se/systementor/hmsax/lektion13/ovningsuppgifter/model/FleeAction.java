package se.systementor.hmsax.lektion13.ovningsuppgifter.model;

public class FleeAction implements BattleAction {
    @Override
    public String label() { return "FleeAction"; }

    @Override
    public void execute(Pokemon user, Pokemon target) {}
}
