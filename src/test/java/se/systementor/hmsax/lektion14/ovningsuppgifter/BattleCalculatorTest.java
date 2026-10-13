package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleCalculatorTest {

    @Test
    void calculateBaseDamage_returnsExactBaseDamage() {
        BattleCalculator calc = new BattleCalculator();
        double damage = calc.calculateBaseDamage(50);

        // Stabil och utan slump[cite: 1]
        assertEquals(50.0, damage, 0.001);
    }
}