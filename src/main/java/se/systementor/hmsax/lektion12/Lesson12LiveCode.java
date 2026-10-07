package se.systementor.hmsax.lektion12;

import java.util.ArrayList;
import java.util.List;

public class Lesson12LiveCode {
    public static void main(String[] args) {

        Animal a1 = new Horse("Hästen", 4, new WalkMove(), true);
        Animal a2 = new Dog("Hunden", 3, new WalkMove(), "MAS");
        Animal a3 = new Cat("Katten", 4, new WalkMove(),  "bondkatt");
        Animal a4 = new Axolotl("Axel", 4, new SwimMove(), true);

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
            a.performMove();
        }

    /*    for (Animal a : zooButiken){
            if (a instanceof Pettable p){
                p.getPetted();
            }
        } */

        Pettable p1 = new Cat("Nisse", 3, new WalkMove(), "Siames");

        Animal katt = new Cat("Findus", 4, new WalkMove(), "Siames");

        katt.performMove();
        System.out.println("Katten blir skrämd och flyger iväg.");

        katt.setMoveStrategy(new FlyMove());
        katt.performMove();





    }

    public static void visitorPetsAnimal(Pettable animal){
        animal.getPetted();
    }
}
