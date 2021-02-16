package Chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

// Project 2.8
public class DistanceFormula {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String myFormat = "###,###.##";
        DecimalFormat df = new DecimalFormat(myFormat);

        System.out.print("Input the first x-coordinate: ");
        double x1 = Float.parseFloat(br.readLine());

        System.out.print("Input the first y-coordinate: ");
        double y1 = Float.parseFloat(br.readLine());

        System.out.print("Input the second x-coordinate: ");
        double x2 = Float.parseFloat(br.readLine());

        System.out.print("Input the second y-coordinate: ");
        double y2 = Float.parseFloat(br.readLine());

        double totalDistance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

        System.out.print("Distance: " + df.format(totalDistance) + " units");

    }
}
