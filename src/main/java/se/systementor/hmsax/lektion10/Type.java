package se.systementor.hmsax.lektion10;

public enum Type {
    FIRE("Eld"),
    WATER("Vatten"),
    GRASS("Gräs"),
    ELECTRIC("Elektrisk"),
    NORMAL("Normal");

    private final String label;

    Type(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
