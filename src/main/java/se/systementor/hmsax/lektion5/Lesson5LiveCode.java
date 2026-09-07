package se.systementor.hmsax.lektion5;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lesson5LiveCode {
    public static void main(String[] args) {

        String text2 = "Hej jag gillar pizza";
        String[] textArray = text2.split(" ");
        for (String item : textArray) {
            System.out.println(item);
        }

        //alternativ för utskrift:
        System.out.println(Arrays.toString(textArray));


        String[] names = {"Anna", "Bertil", "Cecilia"};

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println(intList);
        intList.remove((Integer) 2);
        System.out.println(intList);
        intList.set(0, 4);
        System.out.println(intList);

// Klassisk for — när vi behöver indexet
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + ": " + names[i]);
        }

// for-each — när vi bara vill läsa elementen
        for (String name : names) {
            System.out.println(name);
        }


        String text = "   Det HÄr är EN TeXT   ";
        System.out.println(text + "!");
        text = text.trim().toLowerCase();
        System.out.println(text + "!");
        text = text.toUpperCase();
        System.out.println(text + "!");
        text = text.toLowerCase().replace("det här", "Detta");
        System.out.println(text + "!");
        text = text.substring(0, 5);
        System.out.println(text + "!");
    }
}
