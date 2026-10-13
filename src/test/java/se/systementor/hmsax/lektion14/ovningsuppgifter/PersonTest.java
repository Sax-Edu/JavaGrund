package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    @Test
    void setAge_validAge_setsValue() {
        Person person = new Person();
        person.setAge(30);
        assertEquals(30, person.getAge());
    }

    @Test
    void setAge_negativeAge_throwsIllegalArgumentException() {
        Person person = new Person();
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }

    @Test
    void setAge_tooHighAge_throwsIllegalArgumentException() {
        Person person = new Person();
        assertThrows(IllegalArgumentException.class, () -> person.setAge(250));
    }
}