package se.systementor.hmsax.lektion4.ovningsuppgifter;

public class G4 {
    public static void main(String[] args) {
        System.out.println("Störst av 3 och 7: " + storst(3, 7));
        System.out.println("Störst av 2.5 och 1.9: " + storst(2.5, 1.9));
    }

    public static int storst(int a, int b) {
        return (a > b) ? a : b;
    }

    public static double storst(double a, double b) {
        return (a > b) ? a : b;
    }
}
