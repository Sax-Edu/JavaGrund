package se.systementor.hmsax.lektion14.ovningsuppgifter;

public class TypeChart {
    public static double effectiveness(Type attacker, Type defender) {
        if (attacker == Type.FIRE && defender == Type.GRASS) return 2.0;
        if (attacker == Type.WATER && defender == Type.FIRE) return 2.0;
        if (attacker == Type.GRASS && defender == Type.WATER) return 2.0;
        if (attacker == Type.ELECTRIC && defender == Type.WATER) return 2.0;

        if (attacker == Type.FIRE && defender == Type.WATER) return 0.5;
        if (attacker == Type.WATER && defender == Type.GRASS) return 0.5;
        if (attacker == Type.GRASS && defender == Type.FIRE) return 0.5;

        return 1.0;
    }
}