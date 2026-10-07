package se.systementor.hmsax.lektion12;

public class Horse extends Animal {
    private boolean hasMane;

    public Horse(String name, int amountOfLegs, MoveStrategy moveStrategy, boolean hasMane) {
        super(name, amountOfLegs, moveStrategy);
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