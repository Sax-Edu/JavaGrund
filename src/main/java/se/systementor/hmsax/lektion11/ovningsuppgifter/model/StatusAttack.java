package se.systementor.hmsax.lektion11.ovningsuppgifter.model;

public class StatusAttack extends Attack {
    private final String statusEffect;

    public StatusAttack(String name, int accuracy, String statusEffect) {
        super(name, accuracy);
        if (statusEffect == null || statusEffect.trim().isEmpty()) {
            throw new IllegalArgumentException("Fel: statusEffect får inte vara tomt");
        }
        this.statusEffect = statusEffect;
    }

    public String getStatusEffect() {
        return statusEffect;
    }

    @Override
    public void executeAttack(Pokemon attacker, Pokemon defender) {
        super.executeAttack(attacker, defender);
        System.out.println(defender.getName() + " blev " + statusEffect + ".");
    }
}
