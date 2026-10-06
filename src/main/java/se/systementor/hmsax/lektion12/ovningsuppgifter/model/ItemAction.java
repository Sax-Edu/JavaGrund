package se.systementor.hmsax.lektion12.ovningsuppgifter.model;

public class ItemAction implements BattleAction {
    private final String name;
    private final int healAmount;

    public ItemAction(String name, int healAmount) {
        this.name = name;
        this.healAmount = healAmount;
    }

    @Override
    public String label() {
        return name;
    }

    @Override
    public void execute(Pokemon user, Pokemon target) {
        user.heal(healAmount);
        System.out.println("... " + user.getName() + " använder " + name + " och läker " + healAmount + " HP");
    }
}
