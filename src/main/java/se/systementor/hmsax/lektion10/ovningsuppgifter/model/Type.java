package se.systementor.hmsax.lektion10.ovningsuppgifter.model;

public enum Type {
    FIRE("Eld", true),
    WATER("Vatten", true),
    GRASS("Gräs", true),
    ELECTRIC("El", true),
    NORMAL("Normal", false);

    private final String label;
    private final boolean isSpecial;

    Type(String label, boolean isSpecial) {
        this.label = label;
        this.isSpecial = isSpecial;
    }

    public String getLabel() {
        return label;
    }

    public boolean isSpecial() {
        return isSpecial;
    }
}
