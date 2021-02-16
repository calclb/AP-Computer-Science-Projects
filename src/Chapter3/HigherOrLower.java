package Chapter3;

import java.util.Random;
import java.util.Scanner;

// Project 3.10
public class HigherOrLower {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        boolean isPlaying = true;

        while(isPlaying)
        {
            System.out.print("What should be the minimum number? ");
            int min = s.nextInt();
            System.out.print("What should be the maximum number? ");
            int max = s.nextInt();

            System.out.print("How many guesses? ");
            int maxGuesses = s.nextInt();

            int num = r.nextInt(max - min) + min;
            int guess = 0;

            for(int guessesRemaining = maxGuesses; guessesRemaining > 0; guessesRemaining--) {
                if(guessesRemaining != 1) System.out.println("You have " + guessesRemaining + " guesses remaining.");
                else System.out.println("This is your last guess.");

                System.out.print("Guess a number between " + min + " and " + max + ": ");
                String input = s.next();

                if(input.equalsIgnoreCase("quit")) return;
                guess = Integer.parseInt(input);

                if(guess == num)
                {
                    System.out.println("You guessed the number!");
                    if(maxGuesses - guessesRemaining != 1) System.out.println("You took " + (maxGuesses - guessesRemaining) + " guesses."); else System.out.println("You took 1 guess.");
                    return;
                }
                else if(num > guess) System.out.println("The number is greater than your guess.");
                else System.out.println("The number is less than your guess.");
            }
            System.out.print("You have no guesses remaining.\nYou were off by " + Math.abs(guess - num) + "; the number was " + num + ".\nPlay again (y/n)? ");
            isPlaying = s.next().equalsIgnoreCase("y");
        }
    }
}
