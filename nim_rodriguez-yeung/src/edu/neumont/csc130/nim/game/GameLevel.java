package edu.neumont.csc130.nim.game;

public enum GameLevel {
    EASY(2, 2),
    MEDIUM(2, 5, 7),
    HARD(2, 3, 8, 9);

    public final int nofHeaps;
    public final int[] nofBlocks;

    GameLevel(int... heapInfo) {
        nofHeaps = heapInfo.length;
        nofBlocks = heapInfo;
    }
}
