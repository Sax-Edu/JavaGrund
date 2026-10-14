package se.systementor.hmsax.lektion14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp(){
        calc = new Calculator(); //Arrange
    }

    @Test
    void add_twoPositiveNumbers_returnsSum(){
        int result = calc.add(2,3); //Act
        assertEquals(5, result); //Assert
    }

    @Test
    void isEven_anEvenNumber_returnsTrue(){
        assertTrue(calc.isEven(4));
    }

    @Test
    void isEven_anOddNumber_returnsFalse(){
        assertFalse(calc.isEven(5));
    }

    @Test
    void divide_bAsZero_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10,0));

        //IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calc.divide(10,0));
        //assertEquals("Division med noll ej tillåtet", ex.getMessage());
    }

    @Test
    void getFruits_listIsCorrectAndInOrder(){
        List<String> expected = List.of("Äpple", "Päron", "Banan");
        List<String> actual = calc.getFruits();

        assertIterableEquals(expected,actual);

    }

}