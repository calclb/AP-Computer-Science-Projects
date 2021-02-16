package Chapter6;

import java.util.Scanner;

public class FrequencyTable0to50 {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        // inclusive
        int min = 0;
        int max = 50;
        int amt = 10;
        int[] ints = new int[amt];
        System.out.println("Enter " + amt + " numbers from " + min + " to " + max + ".");

        int numsEntered = 0;
        while(numsEntered < ints.length)
        {
            System.out.print("Enter #" + (numsEntered+1) + ": ");
            int n = s.nextInt();
            if(n < min || n > max)
            {
                System.out.println("Please enter a number from " + min + " to " + max + ".");
                continue;
            }
            ints[numsEntered] = n;
            numsEntered++;
        }

        int[] occurrences = new int[max-min+1];
        for(int i = 0; i < occurrences.length; i++)
        {
            for(int j : ints) if(j == i+min) occurrences[i]++;
            System.out.println((i+min) + "\t| " + occurrences[i]);
        }
    }

}
