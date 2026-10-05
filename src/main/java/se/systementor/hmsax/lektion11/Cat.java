package se.systementor.hmsax.lektion11;

public class Cat extends Animal{
String breed;

    public Cat(String name, int amountOfLegs, String breed){
        super(name, amountOfLegs);
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

}
