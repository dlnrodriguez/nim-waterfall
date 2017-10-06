package edu.neumont.csc130.nim.game;

import edu.neumont.csc130.nim.objects.Heap;

import java.util.Scanner;

public class GamePlay {
    private static Heap[] heaps;
    private int nofEmptyHeaps;

    public static void init(GameLevel gameLevel, Boolean doesNeedInstructions) {
        setupHeaps(gameLevel);

        if (doesNeedInstructions) displayInstructions();
    }

    public GamePlay(Player[] players) {
        for (; ; ) {
            playGame(players[0]);
            playGame(players[1]);
        }
    }

    public static void displayInstructions() {
        System.out.format("> these are instructions\n");
    }

    // * * *
    // private methods
    // * * *

    private void playGame(Player player) {

    }

    private Heap chooseHeap() {
        System.out.printf("From which heap would you like to take a block or blocks?\n");
        Heap decision; // end result of player choosing a heap
        int heapDecision; //

        for (; ; ) {
            // placeholder for user input
            String temp = new Scanner(System.in).next();

            if (!isIntValue(temp)) {
                System.out.printf("Sorry, \"%s\" is not a valid input! Please enter a heap number!\n", temp);
            } else {
                heapDecision = Integer.parseInt(temp);
                if (heapDecision > heaps.length) {
                    System.out.printf("Sorry, \"%d\", is not a valid heap number! Try again.\n", heapDecision);
                } else {
                    decision = heaps[heapDecision - 1];

                    if (decision.isEmpty()) {
                        System.out.printf("Sorry, Heap %d doesn't have any blocks on it. Try again", heapDecision);
                    } else {
                        break;
                    }
                } // heap is empty
            } // is an int value
        } // infinite loop

        return decision;
    }

    private int chooseNumberOfBlocks(Heap heap) {
        System.out.printf("How many blocks would you like to take from Heap %d?", heap.id);
        int decision;

        for (; ; ) {
            String temp = new Scanner(System.in).next();

            if (!isIntValue(temp)) {
                System.out.printf("Sorry, \"%s\" is not a valid input! Please enter a number!\n", temp);
            } else {
                decision = Integer.parseInt(temp);
                if (!heap.removeBlocks(decision)) {
                    System.out.printf("Sorry, there aren't that many blocks on Heap %d. Try again.\n", heap.id);
                } else {
                    break;
                }
            } // is an int value
        } // infinite loop

        return decision;
    }

    private boolean isIntValue(String input) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ignore) {
            return false;
        }
    }

    private boolean isValidMove(Heap heap, int nofBlocks) {
        return heap.removeBlocks(nofBlocks);
    }

    private static void setupHeaps(GameLevel gameLevel) {
        switch (gameLevel) {
            case EASY:
                heaps = new Heap[2];
                heaps[0] = new Heap(2, 1);
                heaps[1] = new Heap(2, 2);
                break;
            case MEDIUM:
                heaps = new Heap[3];
                heaps[0] = new Heap(2, 1);
                heaps[1] = new Heap(5, 2);
                heaps[2] = new Heap(7, 3);
                break;
            case HARD:
                heaps = new Heap[4];
                heaps[0] = new Heap(2, 1);
                heaps[1] = new Heap(3, 2);
                heaps[2] = new Heap(8, 3);
                heaps[3] = new Heap(9, 4);
                break;
        }
    }
}
