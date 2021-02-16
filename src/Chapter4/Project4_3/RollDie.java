package Chapter4.Project4_3;

import Chapter4.Die;

import java.util.Scanner;

public class RollDie {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Pick the number of sides on the die to roll: ");
        Die die = new Die(s.nextInt());
        die.roll();
        System.out.println("You rolled " + die.getFace() + ".");
    }
}
