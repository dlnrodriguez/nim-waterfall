package edu.neumont.csc130.nim;

import edu.neumont.csc130.nim.game.GameLevel;
import edu.neumont.csc130.nim.game.GamePlay;

public class Nim {
    public static void main(String[] args) {
        System.out.printf("%s\n", "hello, world!");

        GamePlay.init(GameLevel.EASY, false);
        GamePlay.test();
        GamePlay.init(GameLevel.MEDIUM, false);
        GamePlay.test();
        GamePlay.init(GameLevel.HARD, false);
        GamePlay.test();
    }
}
