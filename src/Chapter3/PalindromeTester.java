package Chapter3;

import java.util.Scanner;

// Project 3.11
public class PalindromeTester {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true)
        {
            System.out.print("Enter a string ('quit' to quit): ");
            String input = s.nextLine().toLowerCase().trim().replace(" ", "")
                    .replace(".", "")
                    .replace(",", "")
                    .replace("'", "")
                    .replace(";", "")
                    .replace(":", "");

            if(input.equalsIgnoreCase("quit")) return;

            String backwards = "";

            for(int i = input.length() - 1; i >= 0; i--) backwards += input.charAt(i);
            
            if(input.equals(backwards)) System.out.println("It's a palindrome!");
            else System.out.println("It's not a palindrome.");
        }
    }
}
