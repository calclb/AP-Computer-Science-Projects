package Chapter6;

import java.util.Scanner;

public class FreqTable1to100
{
    // inputs 1-100
    // chart showing how often values appear
    // 1-10, 11-20, ..., 91-100
    //
    // print asterisk for each occurrence

    public static void main(String[] args)
    {
        // scanner
        Scanner s = new Scanner(System.in);

        // inclusive
        int lowestValidInput = 1;
        int highestValidInput = 100;

        int numInputs = 10;
        int totalGroups = 10;
        int rangeOfNumbersPerGroup = 10;

        int[] numToOccurrencesMap = new int[highestValidInput - lowestValidInput + 1];
        // i=0, n=1     |
        // i=1, n=2     |
        // ...
        // i=98, n=99   |
        // i=99, n=100  |

        System.out.println("Enter " + numInputs + " numbers from " + lowestValidInput + " to " + highestValidInput);

        // take the inputs
        for(int i = 0; i < numInputs; i++)
        {
            System.out.print("Input a number: ");
            int n = s.nextInt();
            numToOccurrencesMap[n-1] += 1;
        }

        // g0, g1, g2, ..., g9
        for(int g = 0; g < totalGroups; g++)
        {
            int startingIndexOfGroup = totalGroups * g;
            int sum = 0;

            // index 0-9
            for(int i = startingIndexOfGroup; i < startingIndexOfGroup + rangeOfNumbersPerGroup; i++)
            {
                sum += numToOccurrencesMap[i];
            }

            System.out.print((g * rangeOfNumbersPerGroup + 1) + " - " + (g * rangeOfNumbersPerGroup + rangeOfNumbersPerGroup) + "\t|\t");

            // print out each star
            for(int i = 0; i < sum; i++){
                System.out.print("*");
            }

            System.out.println();

        }
    }
}




