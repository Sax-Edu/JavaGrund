package se.systementor.hmsax.lektion5;

import java.util.ArrayList;

public class Room {
    public String roomName;
    public int sqm;
    public ArrayList<Window> windows = new ArrayList<>();

    public Room(){}

    public Room(String roomName, int sqm) {
        this.roomName = roomName;
        this.sqm = sqm;
    }

}

