package se.systementor.hmsax.lektion11;

import se.systementor.hmsax.lektion10.ovningsuppgifter.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Lesson11LiveCode {
    public static void main(String[] args) {

    //    List<Pokemon> pokedex = new ArrayList<>();

        Animal a1 = new Horse("Hästen", 4, true);
        Animal a2 = new Dog("Hunden", 3, "MAS");
        Animal a3 = new Cat("Katten", 4, "bondkatt");
        Animal a4 = new Axolotl("Axel", 4, true);

        List<Animal> zooButiken = new ArrayList<>();

        zooButiken.add(a1);
        zooButiken.add(a2);
        zooButiken.add(a3);
        zooButiken.add(a4);

        for(Animal a : zooButiken){
            a.makeSound();
            a.eatFood();
            if( a instanceof Cat cat){
                System.out.println("Det är verkligen en katt.");
            }
        }


    }
}
