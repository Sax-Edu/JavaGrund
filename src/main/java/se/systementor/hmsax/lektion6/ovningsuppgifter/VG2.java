package se.systementor.hmsax.lektion6.ovningsuppgifter;

// Unchecked Exception (ärver RuntimeException) – Frivillig hantering
class InvalidUserException2 extends RuntimeException {
    public InvalidUserException2(String message) {
        super(message);
    }
}

// Checked Exception (ärver Exception) – Tvingad hantering
// Representerar ett allvarligare systemfel, t.ex. när databasen är nere.
class UserDatabaseException extends Exception {
    public UserDatabaseException(String message) {
        super(message);
    }
}

public class VG2 {

    public static void main(String[] args) {
        // 1. Frivillig hantering (Unchecked / RuntimeException)
        // Metoden behöver INTE 'throws InvalidUserException' i sin signatur.
        // Vi kan anropa den utan try-catch om vi vill, men vi fångar den oftast i UI-lagret.
        try {
            validateUsername("   "); // Kastar InvalidUserException
        } catch (InvalidUserException2 e) {
            System.out.println("Valideringsfel (Unchecked): " + e.getMessage());
        }

        // 2. Tvingad hantering (Checked / Exception)
        // Metoden MÅSTE ha 'throws UserDatabaseException' i signaturen.
        // Kompilatorn nekar bygge om vi inte placerar anropet i ett try-catch-block.
        try {
            saveUserToDatabase("Pikachu"); // Kastar UserDatabaseException
        } catch (UserDatabaseException e) {
            System.out.println("Systemfel (Checked): " + e.getMessage());
        }
    }

    // Unchecked: Behöver inte deklareras i metodsvar/signatur
    public static void validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidUserException2("Namnet får inte vara tomt.");
        }
    }

    // Checked: MÅSTE deklareras med 'throws'
    public static void saveUserToDatabase(String username) throws UserDatabaseException {
        boolean databaseIsDown = true; // Simulerar ett databasfel
        if (databaseIsDown) {
            throw new UserDatabaseException("Kunde inte spara " + username + " till databasen (anslutning saknas).");
        }
    }
}