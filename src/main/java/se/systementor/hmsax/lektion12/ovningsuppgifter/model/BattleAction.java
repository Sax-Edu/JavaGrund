package se.systementor.hmsax.lektion12.ovningsuppgifter.model;

public interface BattleAction {
    String label(); // G1: Menynamn
    void execute(Pokemon user, Pokemon target); // G1: Utför draget

    // G6: Default-metod med standardbeteende
    default boolean consumesTurn() {
        return true;
    }
}