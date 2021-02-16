package Chapter3;

import java.util.Random;
import java.util.Scanner;

// Project 3.15
public class SlotMachine {
    public static void main(String[] args) throws InterruptedException {

        Random r = new Random();
        Scanner s = new Scanner(System.in);
        int[] nums = new int[3];


        while(true) {
            int matchingPermutations = 0;
            int maxPermutations = 0;

            for (int i = 0; i < nums.length; i++) {
                nums[i] = r.nextInt(10);
                maxPermutations += i;

                Thread.sleep(r.nextInt(300) + 500);
                System.out.print(nums[i]);
            }

            for (int i = 0; i < nums.length; i++) {

                for (int j = i + 1; j < nums.length; j++) if (nums[i] == nums[j]) matchingPermutations++;
            }

            System.out.println("\n");

            if (matchingPermutations == maxPermutations) System.out.println("All numbers match!");
            else if (matchingPermutations == 1) System.out.println("There's a match!");
            else System.out.println("No matches.");

            System.out.print("Play again (y/n)? ");
            if(!s.next().equalsIgnoreCase("y")) return;
        }


    }
}
