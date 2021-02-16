package Chapter3;

import java.util.Scanner;

// Project 3.4
public class EvenInteger {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number to get the sum of integers between itself and 2: ");
        int boundInclusive = s.nextInt();
        long sum = 0;

        for(int i = 0; i <= boundInclusive; i++) if(i % 2 == 0) sum += i;

        System.out.println("Sum: "  + sum);
    }
}
