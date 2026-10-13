package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateUtilsTest {

    private final DateUtils dateUtils = new DateUtils();

    @Test
    void isLeapYear_regularLeapYear_returnsTrue() {
        assertTrue(dateUtils.isLeapYear(2024));
    }

    @Test
    void isLeapYear_regularNonLeapYear_returnsFalse() {
        assertFalse(dateUtils.isLeapYear(2023));
    }

    @Test
    void isLeapYear_centuryYearNotDivisibleBy400_returnsFalse() {
        assertFalse(dateUtils.isLeapYear(1900));
    }

    @Test
    void isLeapYear_centuryYearDivisibleBy400_returnsTrue() {
        assertTrue(dateUtils.isLeapYear(2000));
    }
}