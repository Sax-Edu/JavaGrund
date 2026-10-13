package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 250})
    void setAge_invalidAges_throwsException(int invalidAge) {
        Person person = new Person();
        assertThrows(IllegalArgumentException.class, () -> person.setAge(invalidAge));
    }
}
