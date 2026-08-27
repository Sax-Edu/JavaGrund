package se.systementor.hmsax.lektion3.ovningsuppgifter;

import java.util.Scanner;

public class G6DayOfTheWeekWithMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("Ange dag (1-7), eller 8 för att avsluta: ");
            int dayNumber = scanner.nextInt();

            switch (dayNumber) {
                case 1 -> System.out.println("Måndag");
                case 2 -> System.out.println("Tisdag");
                case 3 -> System.out.println("Onsdag");
                case 4 -> System.out.println("Torsdag");
                case 5 -> System.out.println("Fredag");
                case 6 -> System.out.println("Lördag");
                case 7 -> System.out.println("Söndag");
                case 8 -> {
                    System.out.println("Hejdå!");
                    running = false;
                }
                default -> System.out.println("Ogiltig dag.");
            }
        }
        scanner.close();
    }
}
