package Chapter3;

import java.util.Scanner;

// Project 3.6
public class DigitAnalyzer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String input = s.next();

        int oddDigits = 0;
        int evenDigits = 0;
        int zeroDigits = 0;

        for(int i = 0; i < input.length(); i++)
        {
            final int i1 = Integer.parseInt(String.valueOf(input.charAt(i)));
            if(i1 % 2 == 1) oddDigits++;
            else evenDigits++;
            if(i1 == 0) zeroDigits++;
        }

        System.out.println("Odd Digits: " + oddDigits + "\nEven Digits: " + evenDigits + "\nZero Digits: " + zeroDigits);
    }
}
