package Chapter3;

import java.util.Scanner;

// Project 3.9
public class OneHundredBottlesOfBeer {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("How many bottles of beer should I count down from? ");
        int startingNumber = s.nextInt();

        for(int i = startingNumber; i > 1; i--)
        {
            System.out.println(i + " bottles of beer on the wall,\n" + i + " bottles of beer\nIf one of those bottles should happen to fall");
            if(i - 1 != 1) System.out.println((i - 1) + " bottles of beer on the wall."); else System.out.println("1 bottle of beer on the wall.");
        }

        System.out.println("1 bottle of beer on the wall,\n1 bottle of beer\nIf the last bottle should happen to fall\nNo bottles of beer on the wall :(");
    }
}
