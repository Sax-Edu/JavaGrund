package se.systementor.hmsax.lektion5;

import java.util.ArrayList;

public class Window {
    public String name;
    public Color color;
    public boolean openable;
    public ArrayList<String[]> listan = new ArrayList<>();


    public Window(){}

    public Window(String name, Color color, boolean openable){
        this.name = name;
        this.color = color;
        this.openable = openable;
    }
}


