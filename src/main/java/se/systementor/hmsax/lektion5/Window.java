package se.systementor.hmsax.lektion5;

public class Window {
    private String name;
    private Color color;
    private boolean openable;

    public Window(String name, Color color, boolean openable) {

        this.name = name;
        this.color = color;
        this.openable = openable;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public boolean isOpenable() {
        return openable;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Fönstret måste ha ett namn");
            return;
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " is " + color + ". ";
    }
}


