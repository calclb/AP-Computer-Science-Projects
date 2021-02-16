package Chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Project 3.13
public class StringStats {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = s.nextLine();

        int as, es, is, os, us;
        int consonants = 0;
        int spaces, punctuation_marks = 0;


        Map<Character, Integer> cim = new HashMap<>();

        for (int i = 0; i < input.length(); i++)
        {
            cim.put(input.charAt(i), cim.getOrDefault(input.charAt(i), 0) + 1);
        }

        as = cim.getOrDefault('a', 0);
        es = cim.getOrDefault('e', 0);
        is = cim.getOrDefault('i', 0);
        os = cim.getOrDefault('o', 0);
        us = cim.getOrDefault('u', 0);

        consonants = cim.getOrDefault('b', 0)
                + cim.getOrDefault('c', 0)
                + cim.getOrDefault('d', 0)
                + cim.getOrDefault('f', 0)
                + cim.getOrDefault('g', 0)
                + cim.getOrDefault('h', 0)
                + cim.getOrDefault('j', 0)
                + cim.getOrDefault('k', 0)
                + cim.getOrDefault('l', 0)
                + cim.getOrDefault('m', 0)
                + cim.getOrDefault('n', 0)
                + cim.getOrDefault('p', 0)
                + cim.getOrDefault('q', 0)
                + cim.getOrDefault('r', 0)
                + cim.getOrDefault('s', 0)
                + cim.getOrDefault('t', 0)
                + cim.getOrDefault('v', 0)
                + cim.getOrDefault('w', 0)
                + cim.getOrDefault('x', 0)
                + cim.getOrDefault('y', 0)
                + cim.getOrDefault('z', 0);

        punctuation_marks = cim.getOrDefault('.', 0)
                + cim.getOrDefault('!', 0)
                + cim.getOrDefault('?', 0)
                + cim.getOrDefault(',', 0)
                + cim.getOrDefault(':', 0)
                + cim.getOrDefault(';', 0)
                + cim.getOrDefault('\'', 0)
                + cim.getOrDefault('"', 0);

        spaces = cim.getOrDefault(' ', 0);


        System.out.println("A: " + as + "\tE: " + es + "\tI: " + is + "\tO: " + os + "\tU: " + us);
        System.out.println("Vowels: " + (as + es + is + os + us));
        System.out.println("Consonants: " + consonants);
        System.out.println("Punctuation marks: " + punctuation_marks);
        System.out.println("Spaces: " + spaces);
    }
}
