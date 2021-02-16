package Chapter3;

import java.util.Scanner;

// Project 3.2
public class LeapYear {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = s.nextInt();

        if(year >= 1582)
            if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) System.out.println(year + " is a leap year.");
            else System.out.println(year + " is not a leap year.");
        else System.out.println("The Gregorian calendar was not used prior to 1582.");
    }
}
