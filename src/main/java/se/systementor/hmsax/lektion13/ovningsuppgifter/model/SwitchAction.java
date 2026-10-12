package se.systementor.hmsax.lektion13.ovningsuppgifter.model;

public class SwitchAction implements BattleAction {
    @Override
    public String label() { return "SwitchAction"; }

    @Override
    public void execute(Pokemon user, Pokemon target) {}
}
