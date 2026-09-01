package se.systementor.hmsax.lektion4.ovningsuppgifter;

public class G1 {
    public static void main(String[] args) {
        double area1 = beraknaArea(4.0, 3.0);
        double area2 = beraknaArea(5.5, 2.0);

        System.out.println("Area av 4 x 3: " + area1);
        System.out.println("Area av 5.5 x 2.0: " + area2);
    }

    public static double beraknaArea(double bredd, double hojd) {
        return bredd * hojd;
    }
}
