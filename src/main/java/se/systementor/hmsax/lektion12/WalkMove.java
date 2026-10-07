package se.systementor.hmsax.lektion12;

public class WalkMove implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Vandrar omkring.");
    }
}
