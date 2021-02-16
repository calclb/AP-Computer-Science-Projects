package Chapter2;

import java.util.Scanner;

// Project 2.2
public class AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Input three numbers to get an integer average.");

        System.out.print("Integer #1: ");
        int num1 = Integer.parseInt(s.next());

        System.out.print("Integer #2: ");
        int num2 = Integer.parseInt(s.next());

        System.out.print("Integer #3: ");
        int num3 = Integer.parseInt(s.next());

        int average = (num1 + num2 + num3) / 3;
        System.out.println("Average: " + average);

    }
}
