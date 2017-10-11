package edu.neumont.csc130.nim.game;

public class Player {
    private String name;

    Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
