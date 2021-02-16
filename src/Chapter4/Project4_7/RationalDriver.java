package Chapter4.Project4_7;

import java.util.Scanner;

public class RationalDriver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Set the first fraction's numerator: ");
        int numerator = s.nextInt();
        System.out.println("Set the first fraction's denominator: ");
        int denominator = s.nextInt();
        System.out.println("Set the second fraction's numerator: ");
        int numerator2 = s.nextInt();
        System.out.println("Set the second fraction's denominator: ");
        int denominator2 = s.nextInt();

        Rational r1 = new Rational(numerator, denominator);
        Rational r2 = new Rational(numerator2, denominator2);

        boolean validInput = true;

        do
        {
            System.out.println("What operation (add, subtract, multiply or divide) should these fractions perform? ");

            String input = s.next();

            if(input.equalsIgnoreCase("add")) System.out.println("Result: " + r1.add(r2));
            else if(input.equalsIgnoreCase("subtract")) System.out.println("Result: " + r1.subtract(r2));
            else if(input.equalsIgnoreCase("multiply")) System.out.println("Result: " + r1.multiply(r2));
            else if(input.equalsIgnoreCase("divide")) System.out.println("Result: " + r1.divide(r2));
            else validInput = false;

            if(!validInput) System.out.println("Unknown operation.");

        } while(!validInput);
    }
}
