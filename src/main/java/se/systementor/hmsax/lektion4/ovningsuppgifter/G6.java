package se.systementor.hmsax.lektion4.ovningsuppgifter;

public class G6 {
    public static void main(String[] args) {
        tolkaTal("42");
        tolkaTal("abc");
    }

    public static void tolkaTal(String text) {
        try {
            int tal = Integer.parseInt(text);
            System.out.println("\"" + text + "\" -> Talet är " + tal);
        } catch (NumberFormatException e) {
            System.out.println("\"" + text + "\" -> Det där var inget tal.");
        }
    }
}