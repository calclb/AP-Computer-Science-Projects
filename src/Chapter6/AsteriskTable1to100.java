package Chapter6;

import java.util.Scanner;

public class AsteriskTable1to100 {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        // inclusive
        int min = 1;
        int max = 100;
        int amt = 10;
        int groups = 10;
        int numsPerGroup = (max-min+1) / groups;
        int occurrencesPerStar = 1;
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
        for(int g = 0; g < groups; g++)
        {
            int total = 0;
            for(int i = g * numsPerGroup; i < g * numsPerGroup + numsPerGroup; i++)
            {
                for(int j : ints) if(j == i+min) occurrences[i]++;
                total += occurrences[i];
            }

            System.out.print((g * numsPerGroup + 1) + "\t - \t" + (g * numsPerGroup + numsPerGroup) + "\t| ");
            for(int i = 0; i < total / occurrencesPerStar; i++) System.out.print("*");
            System.out.println();
        }
    }
}
