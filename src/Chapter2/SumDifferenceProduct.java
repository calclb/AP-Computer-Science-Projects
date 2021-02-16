package Chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

// Project 2.3
public class SumDifferenceProduct {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String myFormat = "###,###.##";
        DecimalFormat df = new DecimalFormat(myFormat);


        System.out.println("Enter two numbers to get their sum, difference, and product.");


        System.out.print("#1: ");
        double num1 = Double.parseDouble(s.next());

        System.out.print("#2: ");
        double num2 = Double.parseDouble(s.next());

        System.out.println("\nSum: " + df.format(num1 + num2));
        System.out.println("Difference: " + df.format(num1 - num2));
        System.out.println("Product: " + df.format(num1 * num2));

    }
}
