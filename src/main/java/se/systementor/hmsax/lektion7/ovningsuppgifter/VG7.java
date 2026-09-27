package se.systementor.hmsax.lektion7.ovningsuppgifter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VG7 {
/*
    public static void main(String[] args) {
        Path filePath = Path.of("cars.json");

        // --- 1. SKAPA OCH SPARA KOD (OUTPUT) ---
        List<Car> carList = new ArrayList<>();
        Engine e1 = new Engine("B4 Mildhybrid", 197, FuelType.HYBRID);
        Car c1 = new Car("Volvo XC60", 2022, 385000.0, e1);

        Engine e2 = new Engine("Dual Motor", 450, FuelType.ELECTRIC);
        Car c2 = new Car("Tesla Model 3", 2023, 450000.0, e2);

        carList.add(c1);
        carList.add(c2);

        saveCarsToJson(filePath, carList);

        // --- 2. LÄSA IN KOD (INPUT) ---
        System.out.println("\n--- Läser in bilar från JSON ---");
        List<Car> loadedCars = loadCarsFromJson(filePath);

        for (Car c : loadedCars) {
            System.out.println("Inläst bil: " + c.model + " (" + c.year + ") - Pris: "
                    + c.price + " kr | Motor: " + c.engine.name + " (" + c.engine.fuelType + ")");
        }
    }

    // Metod för att spara till JSON
    public static void saveCarsToJson(Path path, List<Car> cars) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), cars);
            System.out.println("Sparade " + cars.size() + " bilar till " + path.getFileName());
        } catch (IOException e) {
            System.err.println("Kunde inte spara till JSON: " + e.getMessage());
        }
    }

    // Metod för att läsa från JSON utan krasch vid filfel
    public static List<Car> loadCarsFromJson(Path path) {
        if (!Files.exists(path)) {
            System.err.println("Filen finns inte: " + path.getFileName());
            return new ArrayList<>();
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Läs JSON till en array och konvertera till List
            Car[] carArray = mapper.readValue(path.toFile(), Car[].class);
            return new ArrayList<>(List.of(carArray));
        } catch (IOException e) {
            System.err.println("Kunde inte ladda JSON (skadad eller fel format): " + e.getMessage());
            return new ArrayList<>();
        }
    }*/
}
