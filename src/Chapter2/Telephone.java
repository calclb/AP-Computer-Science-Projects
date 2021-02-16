package Chapter2;

import java.text.DecimalFormat;
import java.util.Random;

// Project 2.14
public class Telephone {
    public static void main(String[] args) {

        DecimalFormat threeDigitFormat = new DecimalFormat("000");
        DecimalFormat fourDigitFormat = new DecimalFormat("0000");

        Random r = new Random();
        int val1 = r.nextInt(8);
        int val2 = r.nextInt(8);
        int val3 = r.nextInt(8);
        int seq2 = r.nextInt(743);
        int seq3 = r.nextInt(10000);

        System.out.println("Phone Number: " + val1 + val2 + val3 + "-" + threeDigitFormat.format(seq2) + "-" + fourDigitFormat.format(seq3));
    }
}
