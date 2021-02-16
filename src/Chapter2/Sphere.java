package Chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

// Project 2.9
public class Sphere {

    public static void main(String[] args) {

        String myFormat = "###.##";
        DecimalFormat df = new DecimalFormat(myFormat);
        Scanner s = new Scanner(System.in);
        System.out.print("What is the radius of the sphere? ");
        double radius = s.nextDouble();
        System.out.println("Volume: " + df.format(((double) 4 / 3 * Math.PI * Math.pow(radius, 3))) + " units cubed");
        System.out.println("Surface area: " + df.format(4 * Math.PI * Math.pow(radius, 2)) + " units squared");
    }
}

