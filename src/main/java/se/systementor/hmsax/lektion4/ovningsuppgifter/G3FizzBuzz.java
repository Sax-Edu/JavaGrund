package se.systementor.hmsax.lektion4.ovningsuppgifter;

public class G3FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(getFizzBuzz(i));
        }
    }

    public static String getFizzBuzz(int tal) {
        if (tal % 3 == 0 && tal % 5 == 0) {
            return "FizzBuzz";
        } else if (tal % 3 == 0) {
            return "Fizz";
        } else if (tal % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(tal);
        }
    }
}