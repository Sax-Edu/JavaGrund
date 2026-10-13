package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void add_twoPositiveNumbers_returnsSum() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(2, 3);

        // Assert (Förväntat först, faktiskt sedan)
        assertEquals(5, result);
    }

    @Test
    void multiply_twoPositiveNumbers_returnsProduct() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.multiply(3, 4);

        // Assert
        assertEquals(12, result);
    }
}