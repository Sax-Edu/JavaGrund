package se.systementor.hmsax.lektion5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ObjectTest {
    public static void main(String[] args) {


        Path roomPath = Path.of("saved-rooms.txt");
        Path windowPath = Path.of("saved-windows.txt");

        Room kitchen = new Room("Köket", 20);

        Window westWindow = new Window("Fönster åt väst", Color.BLACK, true);
        Window eastWindow = new Window("Fönster åt öst", Color.YELLOW, true);
        Window northWindow = new Window("Fönster åt norr", Color.RED, false);

        northWindow.setName(" "); //Valideringen i setName förhindrar detta
        northWindow.setName("Jättefint fönster åt norr");

        System.out.println(northWindow); //toString() Override
        System.out.println(westWindow);

        Window northWindow2 = new Window(northWindow.getName(), northWindow.getColor(), northWindow.isOpenable());

        Window northWindow3 = northWindow;

        System.out.println(northWindow == northWindow2); //FALSE! Olika, men likadana, objekt.
        System.out.println(northWindow == northWindow3); //TRUE! Pekar på samma objekt


        /*
        kitchen.windows.add(westWindow);
        kitchen.windows.add(eastWindow);
        kitchen.windows.add(northWindow);

        System.out.println(kitchen.roomName + " " + kitchen.sqm + " " + kitchen.windows.get(0).getName());

        for (Window win : kitchen.windows) {
            System.out.println(win.getName() + ", Färg: " + win.getColor() + ", " + (win.isOpenable() ? "öppningsbar" : "fast"));
        }

        Room livingRoom = new Room("Vardagsrummet", 40);

        livingRoom.windows.add(westWindow);

        ArrayList<Room> allRoomsToSave = new ArrayList<>();

        allRoomsToSave.add(kitchen);
        allRoomsToSave.add(livingRoom);

        saveDataToCSV(allRoomsToSave, roomPath, windowPath);

        List<Room> loadedRooms = loadDataFromCSV(roomPath, windowPath);


        System.out.println("\n--- INLÄST DATA ---");
        for (Room r : loadedRooms) {
            System.out.println("Rum: " + r.roomName + " (" + r.sqm + " kvm)");
            for (Window w : r.windows) {
                System.out.println("  - " + w.getName() + ", Färg: " + w.getColor() + ", " + (w.isOpenable() ? "Öppningsbar" : "Fast"));
            }
        }
    }


    private static void saveDataToCSV(ArrayList<Room> rooms, Path roomPath, Path windowPath) {
        ArrayList<String> roomLines = new ArrayList<>();
        ArrayList<String> windowLines = new ArrayList<>();

        for (Room room : rooms) {
            // CSV-format: RoomName,Sqm
            roomLines.add(room.roomName + "," + room.sqm);

            for (Window win : room.windows) {
                // CSV-format: WindowName,Color,Openable,RoomName (Koppling!)
                windowLines.add(win.getName() + "," + win.getColor() + "," + win.isOpenable() + "," + room.roomName);
            }
        }

        String allRooms = String.join("\n", roomLines);

        String allWindows = String.join("\n", windowLines);

        try {
            Files.writeString(roomPath, allRooms);
            Files.writeString(windowPath, allWindows);
            System.out.println("Sparande lyckades!");
        } catch (IOException e) {
            System.err.println("Gick inte att spara filer: " + e.getMessage());
        }
    }

    private static List<Room> loadDataFromCSV(Path roomPath, Path windowPath) {
        List<Room> loadedRooms = new ArrayList<>();

        try {
            // A. Läs alla rumsslingor och skapa Rum-objekt
            List<String> roomLines = Files.readAllLines(roomPath);
            for (String line : roomLines) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                String name = parts[0];
                int sqm = Integer.parseInt(parts[1]);

                Room room = new Room(name, sqm);
                loadedRooms.add(room);
            }

            // B. Läs alla fönsterrader och skapar Fönster-objekt
            List<String> windowLines = Files.readAllLines(windowPath);
            for (String line : windowLines) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                String winName = parts[0];
                Color color = Color.valueOf(parts[1]); // Omvandlar sträng tillbaka till Enum
                boolean openable = Boolean.parseBoolean(parts[2]);
                String belongsToRoom = parts[3];

                Window window = new Window(winName, color, openable);

                // C. Koppla ihop fönstret med rätt rum i listan
                for (Room room : loadedRooms) {
                    if (room.roomName.equalsIgnoreCase(belongsToRoom)) {
                        room.windows.add(window);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Gick inte att läsa in filer: " + e.getMessage());
        }

        return loadedRooms;
    }*/
    }
}

