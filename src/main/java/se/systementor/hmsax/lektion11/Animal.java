package se.systementor.hmsax.lektion11;

public abstract class Animal {
    String name;
    int amountOfLegs;

    protected Animal(String name, int amountOfLegs) {
        this.name = name;
        this.amountOfLegs = amountOfLegs;
    }

    void makeSound() {
        System.out.println(name + " låter!");
    }

    public abstract void eatFood();


}
