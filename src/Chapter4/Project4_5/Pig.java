package Chapter4.Project4_5;

import Chapter4.Die;
import Chapter4.PairOfDice;

import java.util.Scanner;


public class Pig {

    public void start(){

        PairOfDice dice = new PairOfDice();
        Scanner s = new Scanner(System.in);

        final int cap = 100;
        boolean inPlayerPossession = true;

        int runningPlayerScore = 0;
        int runningComputerScore = 0;
        int pointsFromSprint = 0;
        int computerSprintThreshold = 20;

        while(true)
        {
            dice.roll();

            int ones = 0;

            for(Die d : dice.getDiceArray())
            {
                if(d.getFace() == 1) ones++;
            }

            System.out.print(inPlayerPossession ? "You rolled a total of " + dice.getSum() + ". " : "The computer rolled " + dice.getSum() + ". ");

            if(ones > 0)
            {
                System.out.print("Among those dice, a one was rolled.");
                pointsFromSprint = 0;

                if (ones > 1)
                {
                    if(inPlayerPossession) runningPlayerScore = 0; else runningComputerScore = 0;
                    System.out.print(" Two ones, in fact! Thus, " + (inPlayerPossession ? "your" : "the computer's") + " score has been set to " +
                            (inPlayerPossession ? runningPlayerScore : runningComputerScore) + ".");
                }

                System.out.println(" No points were added.");

                inPlayerPossession = !inPlayerPossession;
                System.out.println(inPlayerPossession ? "You are given control of the dice." : "The dice is now given to the computer.");
            }
            else
            {
                pointsFromSprint += dice.getSum();
            }

            if(!(runningPlayerScore >= cap || runningComputerScore >= cap)) System.out.println("You are " +
                    (runningPlayerScore > runningComputerScore ? "winning" : runningPlayerScore == runningComputerScore ? "tied" : "losing")
                    + " at " + runningPlayerScore + "-" + runningComputerScore + ".");

            if(runningPlayerScore >= cap || runningComputerScore >= cap) break;

            if(inPlayerPossession)
            {
                System.out.print("\nDo you wish to roll the dice again? [" + pointsFromSprint + " volatile points] (y/n) ");
                inPlayerPossession = s.next().equalsIgnoreCase("y");
                if(!inPlayerPossession)
                {
                    System.out.println("You give the dice to the computer after banking " + pointsFromSprint + " points.");
                    runningPlayerScore += pointsFromSprint;
                    pointsFromSprint = 0;
                }
            }
            else if (pointsFromSprint > computerSprintThreshold)
            {
                System.out.println("\nThe computer decides to turn the dice over to you after banking " + pointsFromSprint + " points.");
                inPlayerPossession = true;
                runningComputerScore += pointsFromSprint;
                pointsFromSprint = 0;
            }
            else
            {
                System.out.println("\nThe computer rolls the dice.");
            }
        }

        System.out.println(runningPlayerScore > runningComputerScore ? "You won the game!" : "You lost...");
        System.out.println(">\tYour score: " + runningPlayerScore + "\n>\tComputer's score: " + runningComputerScore);
    }
}
