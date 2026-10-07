package se.systementor.hmsax.lektion11;

public class Dog extends Animal {
    String breed;

    public Dog(String name, int amountOfLegs, String breed) {
        super(name, amountOfLegs);
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

}
