package se.systementor.hmsax.lektion11;

public class Axolotl extends Animal {
    boolean isWhole;

    public Axolotl(String name, int amountOfLegs, boolean isWhole){
        super(name, amountOfLegs);
        this.isWhole= isWhole;
    }

    @Override
    public void eatFood() {
        System.out.println(name +" äter nått gott.");
    }
}
