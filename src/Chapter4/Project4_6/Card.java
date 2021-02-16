package Chapter4.Project4_6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Card {

    public final Suit suit;
    public final Run run;

    public Card()
    {
        suit = Suit.getRandomSuit();
        run = Run.getRandomRun();
    }

    public Card(Suit s, Run r)
    {
        suit = s;
        run = r;
    }

    public enum Suit
    {
        SPADES("Spades"), CLUBS("Clubs"), HEARTS("Hearts"), DIAMONDS("Diamonds");

        private String val;
        private static final List<Suit> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        Suit(String val)
        {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }

        public static Suit getRandomSuit()
        {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }

    public enum Run
    {
        TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
        JACK("Jack"), QUEEN("Queen"), KING("King"), ACE("Ace");

        private String val;
        private static final List<Run> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        Run(String val)
        {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }

        public static Run getRandomRun()
        {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }

    public String toString()
    {
        return run + " of " + suit;
    }
}
