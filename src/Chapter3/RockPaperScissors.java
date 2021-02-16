package Chapter3;

import java.util.Random;
import java.util.Scanner;

// Project 3.14
public class RockPaperScissors {

    private static int wins = 0;
    private static int losses = 0;
    private static int ties = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int comChoice;
        System.out.print("How many rounds? ");
        int rounds = s.nextInt();

        String input;

        for(int i = 0; i < rounds; i++)
        {
            System.out.print("Round " + (i + 1) + " - Pick rock, paper, or scissors: ");
            input = s.next().toLowerCase();

            comChoice = r.nextInt(2);

            doWinLogic(input, comChoice);
        }

        System.out.println("You went " + wins + "-" + losses + "-" + ties + " in " + rounds + " total rounds.");
    }

    private static void doWinLogic(String s, int compareTo)
    {
        printComputerChoice(compareTo);

        if(s.equals("rock"))
        {
            switch (compareTo)
            {
                case 0: // rock
                    System.out.println("Tie.");
                    ties++;
                    break;
                case 1: // paper
                    System.out.println("You lost.");
                    losses++;
                    break;
                case 2: // scissors
                    System.out.println("You win.");
                    wins++;
                    break;
            }
        }

        if(s.equals("paper"))
        {
            switch (compareTo)
            {
                case 0: // rock
                    System.out.println("You win.");
                    wins++;
                    break;
                case 1: // paper
                    System.out.println("Tie.");
                    ties++;
                    break;
                case 2: // scissors
                    System.out.println("You lost.");
                    losses++;
                    break;
            }
        }

        if(s.equals("scissors"))
        {
            switch (compareTo)
            {
                case 0: // rock
                    System.out.println("You lose.");
                    losses++;
                    break;
                case 1: // paper
                    System.out.println("You win.");
                    wins++;
                    break;
                case 2: // scissors
                    ties++;
                    System.out.println("Tie.");
                    break;

            }
        }
    }

    private static void printComputerChoice(int choice)
    {
        switch(choice)
        {
            case 0:
                System.out.println("The computer chose rock.");
                break;
            case 1:
                System.out.println("The computer chose paper.");
                break;
            case 2:
                System.out.println("The computer chose scissors.");
                break;
        }
    }
}
