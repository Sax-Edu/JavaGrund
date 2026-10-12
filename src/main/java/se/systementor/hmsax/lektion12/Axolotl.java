package se.systementor.hmsax.lektion12;

public class Axolotl extends Animal {
    boolean isWhole;

    public Axolotl(String name, int amountOfLegs, MoveStrategy moveStrategy, boolean isWhole){
        super(name, amountOfLegs, moveStrategy);
        this.isWhole= isWhole;
    }

    @Override
    public void eatFood() {
        System.out.println(this.getName() +" äter nått gott.");
    }
}
