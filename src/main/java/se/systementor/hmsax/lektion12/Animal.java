package se.systementor.hmsax.lektion12;

public abstract class Animal {
     String name;
     int amountOfLegs;
     private MoveStrategy moveStrategy; //Strategy pattern

    protected Animal(String name, int amountOfLegs, MoveStrategy moveStrategy) {
        this.name = name;
        this.amountOfLegs = amountOfLegs;
        this.moveStrategy = moveStrategy;
    }

    public void performMove(){
        System.out.print(name + ": ");
        moveStrategy.move(); //delegera beteendet till strategin
    }

    //möjliggör ändring av strategin i körtid
    public void setMoveStrategy(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }

    void makeSound() {
        System.out.println(name + " låter!");
    }

    public abstract void eatFood();


}
