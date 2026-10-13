package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberUtilsTest {

    private final NumberUtils utils = new NumberUtils();

    @Test
    void isEven_evenNumber_returnsTrue() {
        assertTrue(utils.isEven(4));
    }

    @Test
    void isEven_oddNumber_returnsFalse() {
        assertFalse(utils.isEven(7));
    }
}