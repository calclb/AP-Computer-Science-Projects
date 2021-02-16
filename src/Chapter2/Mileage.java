package Chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

// Project 2.11
public class Mileage {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.print("Input starting odometer reading in miles: ");
        double startingOdometerReading = s.nextInt();

        System.out.print("Input ending odometer reading in miles: ");
        double endingOdometerReading = s.nextInt();

        System.out.print("Input total gallons of gas used: ");
        double gasUsedInGallons = s.nextDouble();

        double milesTraveled = endingOdometerReading - startingOdometerReading;
        System.out.println("Miles Traveled: " + df.format(milesTraveled));
        System.out.println("Miles per gallon: " + df.format(milesTraveled / gasUsedInGallons));
    }
}
