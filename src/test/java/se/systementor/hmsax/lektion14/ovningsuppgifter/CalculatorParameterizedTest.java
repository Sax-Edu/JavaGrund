package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "2,  3,  5",
            "0,  0,  0",
            "-1, 1,  0",
            "-2, -4, -6"
    })
    void add_variousInputs_returnsExpectedSum(int a, int b, int expected) {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(a, b));
    }
}
