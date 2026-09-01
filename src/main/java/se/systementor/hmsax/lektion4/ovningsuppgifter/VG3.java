package se.systementor.hmsax.lektion4.ovningsuppgifter;

public class VG3 {
    public static void main(String[] args) {
        System.out.println("round (3.14159) -> " + round(3.14159));
        System.out.println("round (3.14159, 2) -> " + round(3.14159, 2));
        System.out.println("round (2.5) -> " + round(2.5));
    }

    public static long round(double tal) {
        return Math.round(tal);
    }

    public static double round(double tal, int decimaler) {
        double faktor = Math.pow(10, decimaler);
        return Math.round(tal * faktor) / faktor;
    }
}
