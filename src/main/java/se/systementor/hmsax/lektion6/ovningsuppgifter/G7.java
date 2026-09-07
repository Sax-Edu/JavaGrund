package se.systementor.hmsax.lektion6.ovningsuppgifter;

import java.util.HashMap;
import java.util.Scanner;

public class G7 {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 42);
        scores.put("Bob", 88);
        scores.put("Charlie", 15);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Namn: ");
        String name = scanner.nextLine().trim();

        if (scores.containsKey(name)) {
            System.out.println(name + " har " + scores.get(name) + " poäng.");
        } else {
            System.out.println("Hittade ingen spelare med namnet " + name + ".");
        }
    }
}
