package se.systementor.hmsax.lektion10;

public class Lesson10LiveCode {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", Type.ELECTRIC, 100);

        System.out.println(pikachu.getName() + " är " + pikachu.getType().getLabel());

        System.out.println(pikachu);
    }
}
