package Chapter4.Project4_6;

public class CardDriver {
    public static void main(String[] args) {

        final int CARDS = 20;
        Card[] cards = new Card[CARDS];

        System.out.println("You were dealt: ");
        for(int i = 0; i < CARDS; i++)
        {
            cards[i] = new Card();
            System.out.println("- " + cards[i]);
        }
    }
}
