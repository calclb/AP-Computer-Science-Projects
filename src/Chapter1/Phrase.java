package Chapter1;

// Project 1.4
public class Phrase {

    public static void main(String[] args) {
        String inspirational_quote = "Knowledge is power";
        String header_footer = "===================================";
        String box_quote = "|       " + inspirational_quote + "        |";
        String box_whitespace = "|                                 |";

        System.out.println(inspirational_quote);

        System.out.println("\nKnowledge");
        System.out.println("   is    ");
        System.out.println("  power  \n");

        System.out.println(header_footer);
        System.out.println(box_whitespace);
        System.out.println(box_quote);
        System.out.println(box_whitespace);
        System.out.println(header_footer);
    }
}
