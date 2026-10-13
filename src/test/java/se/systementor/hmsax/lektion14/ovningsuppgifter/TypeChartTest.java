package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeChartTest {

    @ParameterizedTest
    @CsvSource({
            "FIRE,     GRASS, 2.0",
            "FIRE,     WATER, 0.5",
            "WATER,    FIRE,  2.0",
            "GRASS,    GRASS, 1.0"
    })
    void typeEffectiveness_returnsCorrectMultiplier(Type attacker, Type defender, double expected) {
        double multiplier = TypeChart.effectiveness(attacker, defender);
        assertEquals(expected, multiplier, 0.001); // Inkluderar delta för double-jämförelse
    }
}