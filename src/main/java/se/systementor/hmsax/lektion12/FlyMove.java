package se.systementor.hmsax.lektion12;

public class FlyMove implements MoveStrategy{
    @Override
    public void move() {
        System.out.println("Flyger omkring!");
    }
}
