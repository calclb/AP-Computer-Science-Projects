package Chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

// Project 2.5
public class MilesToKilometersConverter {

    public static void main(String[] args) throws IOException {

        float milesToKmFactor = 1.60935f;

        String myFormat = "###,###.##";
        DecimalFormat df = new DecimalFormat(myFormat);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Miles: ");
        float miles = Float.parseFloat(br.readLine());
        System.out.print("Kilometers: " + df.format(miles * milesToKmFactor));

    }
}
