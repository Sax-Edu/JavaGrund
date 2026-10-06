package se.systementor.hmsax.lektion12.ovningsuppgifter.model;

// G7: Håller två kontrakts-interfaces
public class FleeAction implements BattleAction, Describable {

    @Override
    public String label() {
        return "Fly";
    }

    @Override
    public void execute(Pokemon user, Pokemon target) {
        System.out.println("... " + user.getName() + " försöker fly!");
    }

    @Override
    public String getDescription() {
        return "Pokemonen försöker fly från striden.";
    }
}
