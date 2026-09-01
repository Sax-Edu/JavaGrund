package se.systementor.hmsax.lektion4.ovningsuppgifter;

public class G5 {
    public static void main(String[] args) {
        int tal = 5;
        dubbla(tal);
        System.out.println("Utanför metoden: " + tal);
        // Förklaring: Primitiva typer skickas "by value" (som kopior).
        // Ändringen inuti metoden påverkar därför inte variabeln i main.
    }

    public static void dubbla(int tal) {
        tal = tal * 2;
        System.out.println("Inuti metoden: " + tal);
    }
}
