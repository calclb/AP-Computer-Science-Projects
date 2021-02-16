package Chapter3;

import java.text.DecimalFormat;
import java.util.Scanner;

// Project 3.1
public class RunningAverageModified {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        double total = 0;
        int nums = 0;

        while(true)
        {
            System.out.print("Enter a number (or 'quit' to quit): ");
            String input = s.next();

            if(input.equals("quit")) return;
            total += Double.parseDouble(input);
            nums++;
            System.out.println("Running average: " + df.format(total/nums));
        }
    }
}
