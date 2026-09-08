package se.systementor.hmsax.lektion6.ovningsuppgifter;

// Custom exception-klass
class InvalidUserException extends RuntimeException {
    public InvalidUserException(String message) {
        super(message);
    }
}

public class VG1 {
    public static void main(String[] args) {
        testCreateUser("Pikachu");
        testCreateUser("   ");
    }

    public static void testCreateUser(String username) {
        System.out.println("Skapar användare: '" + username + "'");
        try {
            validateUsername(username);
            System.out.println("OK: " + username.trim());
        } catch (InvalidUserException e) {
            System.out.println("Avvisad: " + e.getMessage());
        }
    }

    public static void validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidUserException("Namnet får inte vara tomt.");
        }
    }
}
