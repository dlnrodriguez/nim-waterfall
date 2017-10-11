package edu.neumont.csc130.nim.game;

import edu.neumont.csc130.nim.objects.Heap;

import java.util.Scanner;

class GamePlay {
    private static Heap[] heaps;
    private int nofEmptyHeaps;
    private boolean hasGameEnded = false;

    private Player computer = new Player("Computer");

    static void init(GameLevel gameLevel) {
        setupHeaps(gameLevel);
    }

    GamePlay(Player[] players) {
        Player p1, p2;

        p1 = players[0];

        if (players.length == 1) { // player vs computer
            p2 = computer;
        } else {
            p2 = players[1];
        }

        for (; !hasGameEnded; ) {
            playGame(p1);
            playGame(p2);
        }
    }

    // * * *
    // private methods
    // * * *

    private void playGame(Player player) {
        if (hasGameEnded) return;

        printHeaps();
        System.out.printf("%s, ", player);
        Heap chosen = chooseHeap();
        System.out.printf("%s, ", player);
        chooseNumberOfBlocks(chosen);

        if (chosen.isEmpty()) {
            nofEmptyHeaps++;
            if (nofEmptyHeaps == heaps.length) {
                endGame(player);
            }
        }
    }

    private Heap chooseHeap() {
        System.out.printf("from which heap would you like to take a block or blocks?\n");
        Heap decision; // end result of player choosing a heap

        for (; ; ) {
            // placeholder for user input
            String temp = new Scanner(System.in).next();

            if (!isIntValue(temp)) {
                System.out.printf("Sorry, \"%s\" is not a valid input! Please enter a heap number!\n", temp);
            } else {
                int heapDecision = Integer.parseInt(temp);

                if (heapDecision > heaps.length || heapDecision < 1) {
                    System.out.printf("Sorry, \"%d\", is not a valid heap number! Try again.\n", heapDecision);
                } else {
                    decision = heaps[heapDecision - 1];

                    if (decision.isEmpty()) {
                        System.out.printf("Sorry, Heap %d doesn't have any blocks on it. Try again\n", heapDecision);
                    } else {
                        break;
                    }
                } // heap is empty
            } // is an int value
        } // infinite loop

        return decision;
    }

    private void printHeaps() {
        for (Heap heap : heaps) System.out.println(heap);
    }

    private int chooseNumberOfBlocks(Heap heap) {
        System.out.printf("how many blocks would you like to take from Heap %d?\n", heap.id);
        int decision;

        for (; ; ) {
            String temp = new Scanner(System.in).next();

            if (!isIntValue(temp)) {
                System.out.printf("Sorry, \"%s\" is not a valid input! Please enter a number!\n", temp);
            } else {
                decision = Integer.parseInt(temp);
                if (!isValidMove(heap, decision)) {
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
        heaps = new Heap[gameLevel.nofHeaps];

        int heapNumber = 0;
        for (int nofBlocks : gameLevel.nofBlocks) heaps[heapNumber] = new Heap(nofBlocks, ++heapNumber);
    }

    public void endGame(Player loser) {
        hasGameEnded = true;
        System.out.printf("%s lost this round!\n", loser);
    }
}
