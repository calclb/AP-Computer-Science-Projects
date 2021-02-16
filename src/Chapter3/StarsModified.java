package Chapter3;

// Project 3.12
public class StarsModified {
    public static void main(String[] args) {
        String starString = "*********";
        String voidString = starString.replace('*', ' ');

        int max_length = starString.length();

        // a
        for(int i = 0; i < max_length; i++) System.out.println(starString.substring(i));

        // b
        for(int i = 0; i <= max_length; i++)
        {
            System.out.print(voidString.substring(i));
            System.out.println(starString.substring(max_length-i));
        }

        // c
        for (int i = 0; i <= max_length; i++)
        {
            System.out.print(voidString.substring(max_length-i));
            System.out.println(starString.substring(i));
        }

        System.out.println();

        // d
        for (int i = 0; i < (max_length + 1) / 2; i++)
        {

            System.out.print(voidString.substring(i + max_length / 2 + 1));
            System.out.print(starString.substring(max_length-i));

            System.out.print(starString.charAt(0));

            System.out.print(starString.substring(max_length-i));
            System.out.println(voidString.substring(i + max_length / 2 + 1));
        }

        for (int i = (max_length) / 2; i >= 0; i--)
        {
            System.out.print(voidString.substring(i + max_length / 2 + 1));
            System.out.print(starString.substring(max_length-i));

            System.out.print(starString.charAt(0));

            System.out.print(starString.substring(max_length-i));
            System.out.println(voidString.substring(i + max_length / 2 + 1));
        }
    }
}
