package se.systementor.hmsax.lektion14;

import java.util.List;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division med noll ej tillåtet");
        }
        return a / b;
    }

    public List<String> getFruits() {
        return List.of("Äpple", "Päron", "Banan");
    }

}
