package se.systementor.hmsax.lektion12;

public class Dog extends Animal implements Pettable {
    String breed;

    public Dog(String name, int amountOfLegs, MoveStrategy moveStrategy, String breed) {
        super(name, amountOfLegs, moveStrategy);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println("VOFF!");
    }

    @Override
    public void eatFood() {
        System.out.println(name + " äter ett ben.");
    }

    @Override
    public void getPetted() {
        System.out.println(name +" blir klappad och viftar på svansen.");
    }
}
