package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.ArrayList;

public class VG4 {
    private static final ArrayList<Double> log = new ArrayList<>();

    public static void main(String[] args) {
        addMeasurement(200);   // Ogiltig
        addMeasurement(21.5);  // Giltig
        updateMeasurement(9, 18); // Ogiltigt index
    }

    public static boolean isValidTemperature(double temp) {
        return temp >= -50.0 && temp <= 60.0;
    }

    public static void addMeasurement(double temp) {
        if (!isValidTemperature(temp)) {
            System.out.println("Ogiltig mätning: måste vara mellan -50 och 60.");
            return;
        }
        log.add(temp);
        System.out.println("Tillagd: " + temp);
    }

    public static void updateMeasurement(int index, double temp) {
        if (index < 0 || index >= log.size()) {
            System.out.println("Det finns ingen mätning på position " + index + ".");
            return;
        }
        if (!isValidTemperature(temp)) {
            System.out.println("Ogiltig mätning: måste vara mellan -50 och 60.");
            return;
        }
        log.set(index, temp);
        System.out.println("Uppdaterad position " + index + " till: " + temp);
    }
}
