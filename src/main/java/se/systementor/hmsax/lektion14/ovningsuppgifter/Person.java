package se.systementor.hmsax.lektion14.ovningsuppgifter;

public class Person {
    private int age;

    public void setAge(int age) {
        if (age <= 0 || age > 150) {
            throw new IllegalArgumentException("Ogiltig ålder: " + age);
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}