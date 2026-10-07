package se.systementor.hmsax.lektion12;

public class Cat extends Animal implements Pettable {
String breed;

    public Cat(String name, int amountOfLegs, MoveStrategy moveStrategy, String breed){
        super(name, amountOfLegs, moveStrategy);
        this.breed= breed;
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("MJAU!");
    }

    @Override
    public void eatFood() {
        System.out.println(name +" äter allt den kommer åt.");
    }

    @Override
    public void getPetted() {
        System.out.println(name +" blir klappad.");
    }
}
