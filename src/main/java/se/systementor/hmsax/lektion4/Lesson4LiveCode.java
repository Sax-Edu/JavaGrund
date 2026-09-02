package se.systementor.hmsax.lektion4;


import java.util.Scanner;

public class Lesson4LiveCode {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getFizzBuzz(i));
        }

        //Här nedan är ett exempel på anrop till metoden readInt som vi skapade i klassen InputHelper
        Scanner scan = new Scanner(System.in);
        int halpInt = InputHelper.readInt(scan, "Hej");
        System.out.println(halpInt);

    }

    public static String getFizzBuzz(int n) {
        String answer = "";

        if (n % 3 == 0 && n % 5 == 0) {
            answer = "FizzBuzz";
        } else if (n % 3 == 0) {
            answer ="Fizz";
        } else if (n % 5 == 0) {
            answer = "Buzz";
        } else {
            answer = String.valueOf(n);
        }
        return answer;
    }



    /*
    public static void main(String[] args) {
        int[] intArray = new int[3];
        int[] intArray2 = {1,2,3};

        String[] myStringArray = {"hej", "på","dig"};

        System.out.println(myStringArray[4]); //ArrayIndexOutOfBoundsExeption

    }

    //method overloading nedan
    public static void main(String[] args) {
            int storst = (int) max(120.5, 65.0);

        System.out.println("störst är " +storst);

    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    public static double max(double a, double b) {
        return (a > b) ? a : b;
    }
    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    //scope och lokala variabler nedan
    
    public static void doubleIt(int x) {
        int abc = 15;
        x = x * 2;
        System.out.println("Inuti metoden: " + x);
    }

    public static void main(String[] args) {
        int n = 5;

        doubleIt(n);
        System.out.println("Utanför: " + n);   // Fortfarande 5!
    }

*/
}

