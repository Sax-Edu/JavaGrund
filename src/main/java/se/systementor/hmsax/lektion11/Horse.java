package se.systementor.hmsax.lektion11;

public class Horse extends Animal {
    private boolean hasMane;

    public Horse(String name, int amountOfLegs, boolean hasMane) {
        super(name, amountOfLegs);
        this.hasMane = hasMane;
    }

    @Override
    public void makeSound() {
        System.out.println("GNÄGG!");
    }

    @Override
    public void eatFood() {
        System.out.println(name +" äter havre.");
    }
}