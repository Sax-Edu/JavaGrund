package se.systementor.hmsax.lektion2;

public class DiscountCalc {
    public static void main(String[] args) {
        double price = 199.0;
        int discountPercent = 20; //Vad händer om vi sätter denna variabel större än 100?
        double discount = price * discountPercent / 100.0;
        double finalPrice = price - discount;
        System.out.println("Du betalar: " + finalPrice + " kr");
    }
}
