package Chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

// Project 2.2
/*
   The program still accomplishes getting the average of three numbers,
   but can also do so with any amount of numbers.
*/
public class Average {

    private static ArrayList<Double> vals = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.out.println("Input scores (or 'avg' to calculate the average): ");
        handleUserInput();
    }

    private static double findAverageOf(ArrayList<Double> nums) {
        nums.trimToSize();
        double sum = 0d;
        for (double num : nums) sum += num;
        if (nums.isEmpty()) return 0d;
        return (sum / nums.size());
    }

    private static void handleUserInput() throws IOException {
        String myFormat = "###,###.##";
        DecimalFormat df = new DecimalFormat(myFormat);

        try {
            System.out.print("Input field " + (vals.size() + 1) + ": ");
            String input = getNextUserInput();

            if (input.contains("avg") || input.isEmpty()) {
                System.out.println("Average: " + df.format(findAverageOf(vals)));
            } else {
                vals.add(Double.parseDouble(input));
                handleUserInput();
            }
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            System.out.println("[!]: Please do not use characters other than those applicable for numbers.");
            handleUserInput();
        }

    }

    private static String getNextUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
