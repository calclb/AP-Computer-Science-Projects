package Chapter3;

import java.util.Scanner;

// Project 3.5
public class StringReader
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Input a string: ");
        String input = s.nextLine();

        for(int i = 0; i < input.length(); i++) System.out.println(input.charAt(i));
    }
}
