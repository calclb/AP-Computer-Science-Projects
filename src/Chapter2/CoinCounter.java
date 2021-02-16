package Chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

// Project 2.12
public class CoinCounter {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("Enter the number of quarters: ");
        double quarterValue = s.nextInt() / 4d;

        System.out.print("Enter the number of dimes: ");
        double dimeValue = s.nextInt() / 10d;

        System.out.print("Enter the number of nickels: ");
        double nickelValue = s.nextInt() / 20d;

        System.out.print("Enter the number of pennies: ");
        double pennyValue = s.nextInt() / 100d;

        System.out.println("Total value: $" + df.format(quarterValue + dimeValue + nickelValue + pennyValue));
    }
}
