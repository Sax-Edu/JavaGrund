package se.systementor.hmsax.lektion11.ovningsuppgifter.model;

import se.systementor.hmsax.lektion10.ovningsuppgifter.model.Type;

import java.util.Random;

public class DamageAttack extends Attack {
    private final int power;
    private final Type attackType;
    private final boolean canCritical;
    private static final Random random = new Random();

    // Enkel konstruktor (G2, G3)
    public DamageAttack(String name, int accuracy, int power) {
        super(name, accuracy);
        this.power = power;
        this.attackType = Type.NORMAL;
        this.canCritical=false;
    }

    // Utökad konstruktor för VG1 (typeffektivitet) & VG3 (kritiska träffar)
    public DamageAttack(String name, int accuracy, int power, Type attackType, boolean canCritical) {
        super(name, accuracy); // G2: Anropar basklassens konstruktor

        // G3: Egen validering i subklassen
        if (power <= 0) {
            throw new IllegalArgumentException("Fel: power maste vara > 0");
        }
        this.power = power;
        this.attackType = attackType;
        this.canCritical = canCritical;
    }

    public int getPower() {
        return power;
    }

    public Type getAttackType() {
        return attackType;
    }

    @Override
    public void execute(Pokemon attacker, Pokemon defender) {
        // G5: Återanvänd basklassens loggskrift
        super.execute(attacker, defender);

        // VG3: Beräkna kritisk träff
        boolean isCrit = canCritical && (random.nextInt(16) == 0); // ~1 på 16 chanser
        if (isCrit) {
            System.out.print("KRITISK TRAFF! ");
        }

        // VG1: Beräkna typeffektivitetsfaktor
        double multiplier = getTypeMultiplier(this.attackType, defender.getType());
        if (multiplier > 1.0) {
            System.out.print("Det ar supereffektivt! ");
        } else if (multiplier < 1.0 && multiplier > 0) {
            System.out.print("Det var inte sa effektivt... ");
        }

        int actualDamage = (int) (power * multiplier * (isCrit ? 2.0 : 1.0));
        defender.takeDamage(actualDamage);

        System.out.println(defender.getName() + " tar " + actualDamage + " skada.");
    }

    // VG1: Hjälpfunktion för typeffektivitet
    private double getTypeMultiplier(Type atk, Type def) {
        if (atk == Type.FIRE && def == Type.GRASS) return 2.0;
        if (atk == Type.WATER && def == Type.FIRE) return 2.0;
        if (atk == Type.GRASS && def == Type.WATER) return 2.0;
        if (atk == Type.ELECTRIC && def == Type.WATER) return 2.0;

        if (atk == Type.GRASS && def == Type.FIRE) return 0.5;
        if (atk == Type.FIRE && def == Type.WATER) return 0.5;
        if (atk == Type.WATER && def == Type.GRASS) return 0.5;
        if (atk == Type.WATER && def == Type.ELECTRIC) return 0.5;

        return 1.0;
    }
}
