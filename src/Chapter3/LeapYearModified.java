package Chapter3;

import java.util.Scanner;

// Project 3.3
public class LeapYearModified {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true)
        {
            System.out.print("Enter year (or 'quit' to quit): ");
            String input = s.next();
            if(input.equalsIgnoreCase("quit")) return;
            int year = Integer.parseInt(input);

            if(year >= 1582)
                if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) System.out.println(year + " is a leap year.");
                else System.out.println(year + " is not a leap year.");
            else System.out.println("The Gregorian calendar was not used prior to 1582.");
        }
    }
}
