package Chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

// Project 2.10
public class HeronsForm {
    public static void main(String[] args) {

        String myFormat = "###,###.##";
        DecimalFormat df = new DecimalFormat(myFormat);
        Scanner s = new Scanner(System.in);
        System.out.println("Input triangle side lengths to calculate its area.");
        System.out.print("Side length 1: ");
        double sl1 = s.nextDouble();
        System.out.print("Side length 2: ");
        double sl2 = s.nextDouble();
        System.out.print("Side length 3: ");
        double sl3 = s.nextDouble();
        double perimeter = sl1 + sl2 + sl3;
        System.out.println("Area: " + df.format(calcTriangleArea(perimeter, sl1, sl2, sl3)) + " units squared");

    }

    private static double calcTriangleArea(double p, double l1, double l2, double l3) {
        double s = 0.5d * p;
        return Math.sqrt(s * (s - l1) * (s - l2) * (s - l3));
    }
}
