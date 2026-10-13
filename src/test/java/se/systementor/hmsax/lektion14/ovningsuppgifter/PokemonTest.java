package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PokemonTest {

    @Test
    void constructor_validInput_createsPokemon() {
        assertDoesNotThrow(() ->
                new Pokemon("Pikachu", Type.ELECTRIC, 35, List.of("Thunderbolt"))
        );
    }

    @Test
    void constructor_invalidHp_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Pokemon("Pikachu", Type.ELECTRIC, -10, List.of("Thunderbolt"))
        );
    }

    @Test
    void constructor_emptyName_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Pokemon("", Type.ELECTRIC, 35, List.of("Thunderbolt"))
        );
    }

    @Test
    void constructor_tooManyAttacks_throwsException() {
        List<String> fiveAttacks = List.of("A1", "A2", "A3", "A4", "A5");
        assertThrows(IllegalArgumentException.class, () ->
                new Pokemon("Pikachu", Type.ELECTRIC, 35, fiveAttacks)
        );
    }
}