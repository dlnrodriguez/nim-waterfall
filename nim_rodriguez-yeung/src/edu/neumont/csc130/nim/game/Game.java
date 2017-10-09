package edu.neumont.csc130.nim.game;

import java.util.Scanner;

public class Game
{
    private Player[] players;
    private GameLevel gameLevel;
    private Scanner userInput = new Scanner(System.in);

    public Game() {}

    public void play()
    {
        new GamePlay(players);
    }

    public void endGame(Player player)
    {
        System.out.println("Player - " + player.getName() + "lost the game" );
    }

    public Player[] getPlayers()
    {
        return players;
    }

    private void displayInstrutions()
    {
        System.out.println("Game Instruction");
        System.out.println("Player will pick at least one block from a row");
        System.out.println("Player can only pick block from one row, can't go to other row after picked a block from a row");
        System.out.println("Whoever picked the last block lose the game");
    }

    private Player[] promptForPlayerInfo()
    {
        Player[] tempPlayers = new Player[2];

        System.out.println("Player 2, please input their your name");
        System.out.print("     > ");
        String nameOfPlayer1 = userInput.nextLine();
        tempPlayers[0] = new Player(nameOfPlayer1);
        System.out.println("Welcome, Player - " + nameOfPlayer1);

        System.out.println("Player 2, please input their your name");
        System.out.print("     > ");
        String nameOfPlayer2 = userInput.nextLine();
        tempPlayers[1] = new Player(nameOfPlayer2);
        System.out.println("Welcome, Player - " + nameOfPlayer1);

        return tempPlayers;

    }

    private boolean doesNeedInstruction()
    {
        System.out.println("Do you want read the instruction for this game (Y/N)");
        String userDecision = "";
        do
        {
            System.out.print("     > ");
            userDecision = userInput.nextLine();

            if(!userDecision.equalsIgnoreCase("Y") || !userDecision.equalsIgnoreCase("N"))
            {
                System.out.println("Please input \"Y\" or \"N\"");
            }
        }
        while(!userDecision.equalsIgnoreCase("Y") || !userDecision.equalsIgnoreCase("N"));

        if(userDecision.equalsIgnoreCase("Y"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean promptToPlayAgain()
    {
        System.out.println("Do you want to play the game one more time (Y/N)");
        String userDecision = "";
        do
        {
            System.out.print("     > ");
            userDecision = userInput.nextLine();

            if(!userDecision.equalsIgnoreCase("Y") || !userDecision.equalsIgnoreCase("N"))
            {
                System.out.println("Please input \"Y\" or \"N\"");
            }
        }
        while(!userDecision.equalsIgnoreCase("Y") || !userDecision.equalsIgnoreCase("N"));

        if(userDecision.equalsIgnoreCase("Y"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
