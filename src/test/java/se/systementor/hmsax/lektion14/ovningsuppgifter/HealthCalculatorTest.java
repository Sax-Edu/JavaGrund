package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthCalculatorTest {

    @Test
    void bmi_validInput_returnsCorrectBmiWithDelta() {
        HealthCalculator calc = new HealthCalculator();
        double result = calc.bmi(70, 1.80);

        // Använder delta (0.01) för att acceptera avrundningsdifferenser
        assertEquals(21.60, result, 0.01);
    }
}