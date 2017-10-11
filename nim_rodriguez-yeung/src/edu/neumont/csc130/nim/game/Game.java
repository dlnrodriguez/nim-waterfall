package edu.neumont.csc130.nim.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Player players[];

    public Game() {
        setYes();
        promptForPlayerInfo();
    }

    private void displayInstructions() {
        System.out.println("Game Instructions:");
        System.out.println("There are two players; one may be a computer.");
        System.out.println("During a player's turn, the current player");
        System.out.println("must remove a number of blocks from a heap");
        System.out.println("of their choice. The player to take the last");
        System.out.println("block loses the game.");

        System.out.println("\u001B[34m" + "Press the return key to continue." + "\u001B[0m"); // prints blue
        new Scanner(System.in).hasNextLine();
    }

    private void promptForPlayerInfo() {
        System.out.printf("How many players are going to play?\n");
        int n;

        do {
            try {
                n = new Scanner(System.in).nextInt();
            } catch (InputMismatchException ignore) {
                n = -1;
                System.out.printf("That wasn't a number! If you would like to play against a" +
                        "\nfriend, enter \'2\'. Playing against our computer? Enter \'1\'.\n");
            }

        } while (n < 0 || n > 3);

        players = new Player[n];

        if (n == 1) {
            System.out.println("Player, please enter your name.");
            String playerName = new Scanner(System.in).nextLine();
            players[0] = new Player(playerName);
        } else if (n == 2) {
            System.out.println("Player 1, please enter your name.");
            String nameOfPlayer1 = new Scanner(System.in).nextLine();
            players[0] = new Player(nameOfPlayer1);

            System.out.println("Player 2, please enter your name.");
            String nameOfPlayer2 = new Scanner(System.in).nextLine();
            players[1] = new Player(nameOfPlayer2);
        }

        if (doesNeedInstruction()) displayInstructions();

        do {
            System.out.printf("At which level would you like to play? Easy, medium, or hard?\n");
            String level = new Scanner(System.in).next();
            play(GameLevel.valueOf(level.toUpperCase()));
        } while (promptToPlayAgain());
    }

    private boolean doesNeedInstruction() {
        System.out.println("Will you need instructions to play?");
        String userDecision = new Scanner(System.in).next();
        return is_a_yes(userDecision);
    }

    private void play(GameLevel level) {
        GamePlay.init(level);
        new GamePlay(players);
    }

    private boolean promptToPlayAgain() {
        System.out.println("Would you like to play again?");
        String userDecision = new Scanner(System.in).nextLine();
        return is_a_yes(userDecision);
    }

    private static ArrayList<String> list = new ArrayList<>();

    private static void setYes() {
        list.add("y");
        list.add("yes");
        list.add("yea");
        list.add("yeah");
        list.add("sure");
        list.add("yup");
        list.add("mhm");
        list.add("duh");
        list.add("maybe");
        list.add("thumbs up");
        list.add("i guess");
        list.add("i don't care");
    }

    private static boolean is_a_yes(String s) {
        return list.contains(s.toLowerCase());
    }
}
