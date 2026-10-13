package se.systementor.hmsax.lektion14.ovningsuppgifter;

public class BattleCalculator {

    // Deterministisk metod som kan enhetstestas stabilt
    public double calculateBaseDamage(int baseDamage) {
        return baseDamage;
    }

    // Slumpmässig metod som anropar den deterministiska metoden
    public int attackDamage(int baseDamage) {
        double randomFactor = 0.85 + (Math.random() * 0.15); // Slump mellan 0.85 och 1.0
        return (int) (calculateBaseDamage(baseDamage) * randomFactor);
    }
}
