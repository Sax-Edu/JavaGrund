package se.systementor.hmsax.lektion14.ovningsuppgifter;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserServiceTest {

    private final UserService userService = new UserService();
    private final List<String> users = List.of("alice", "bob", "carol");

    @Test
    void findUser_existingUser_returnsName() {
        String result = userService.findUser(users, "bob");
        assertEquals("bob", result);
    }

    @Test
    void findUser_nonExistingUser_returnsNull() {
        String result = userService.findUser(users, "eve");
        assertNull(result);
    }
}