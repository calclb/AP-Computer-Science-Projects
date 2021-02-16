package Chapter3;

import java.util.Scanner;

// Project 3.7
public class MultiplicationTable {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Minimum: ");
        int minimum = s.nextInt();

        System.out.print("Maximum: ");
        int maximum = s.nextInt();

        int diff = Math.abs(maximum - minimum);

        for(int i = 0; i < diff + 1; i++)
        {
            for(int j = 0; j < diff + 1; j++) System.out.print((i + minimum) * (j + minimum) + "\t");
            System.out.println();
        }
    }
}
