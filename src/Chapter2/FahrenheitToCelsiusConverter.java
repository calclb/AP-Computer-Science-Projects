package Chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;

// Project 2.4
public class FahrenheitToCelsiusConverter {

    public static void main(String[] args) {

        String myFormat = "###,###.##";
        DecimalFormat df = new DecimalFormat(myFormat);

        Scanner s = new Scanner(System.in);

        System.out.println("Enter a temperature in Fahrenheit to get its value in Celsius.");

        System.out.print("Temperature in Fahrenheit: ");
        float tempToConvert = Float.parseFloat(s.next());

        float tempInCelsius = ((float) 5 / 9) * (tempToConvert - 32);
        System.out.println("Temperature in Celsius: " + df.format(tempInCelsius) + " degrees");
    }
}
