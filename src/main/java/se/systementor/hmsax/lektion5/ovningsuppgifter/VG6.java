package se.systementor.hmsax.lektion5.ovningsuppgifter;

import java.util.ArrayList;
import java.util.Scanner;

public class VG6 {
    // Krasch-säker läsInt enligt lektionsmall
    public static int lasInt(Scanner scanner, String prompt) { 
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt tal. Försök igen.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>(); 
        ArrayList<Integer> hps = new ArrayList<>(); 

        while (true) {
            System.out.println("\n1) Lägg till 2) Lista 3) Sök 4) Ta bort 5) Avsluta"); 
            int choice = lasInt(scanner, "Val: "); 

            if (choice == 1) {
                System.out.print("Namn: "); 
                String name = scanner.nextLine();
                int hp = lasInt(scanner, "HP: "); 

                names.add(name); 
                hps.add(hp); 
                System.out.println("Tillagd: " + name + " (" + hp + " HP)"); 

            } else if (choice == 2) {
                for (int i = 0; i < names.size(); i++) { 
                    System.out.println(names.get(i) + " (" + hps.get(i) + " HP)");
                }

            } else if (choice == 3) {
                System.out.print("Sök namn: "); 
                String search = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < names.size(); i++) { 
                    if (names.get(i).equalsIgnoreCase(search)) { 
                        System.out.println(names.get(i) + " (" + hps.get(i) + " HP)"); 
                        found = true;
                    }
                }
                if (!found) System.out.println("Hittades inte.");

            } else if (choice == 4) {
                System.out.print("Ta bort namn: ");
                String removeName = scanner.nextLine();
                boolean removed = false;
                for (int i = 0; i < names.size(); i++) { 
                    if (names.get(i).equalsIgnoreCase(removeName)) {
                        System.out.println("Tog bort: " + names.get(i)); 
                        names.remove(i); 
                        hps.remove(i); 
                        removed = true;
                        break;
                    }
                }
                if (!removed) System.out.println("Namnet hittades inte.");

            } else if (choice == 5) {
                break;
            }
        }
    }
}
