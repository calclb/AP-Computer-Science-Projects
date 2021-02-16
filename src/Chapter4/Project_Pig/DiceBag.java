package Chapter4.Project_Pig;

import Chapter4.Die;
import Utils.Colorizer;

public class DiceBag {

    private final Die[] dice;

    /**
     * If no <code>sides</code> parameter is provided, this class constructor is called using dice with 6 faces.
     */
    public DiceBag(int numDice) {
        this(numDice, 6);
    }

    /**
     * Constructs an object designed to abstract a relationship between multiple dice.
     *
     * @param numDice The number of dice to use; if <code>numDice < 2</code>, an <code>IllegalArgumentException</code> will be
     *                thrown as otherwise there is no point to create an instance of this class.
     * @param sides   The number of sides for each die to have
     * @see IllegalArgumentException
     */
    public DiceBag(int numDice, int sides) {
        if (numDice < 2) throw new IllegalArgumentException("There must be at least two dice!");

        dice = new Die[numDice];
        for (int i = 0; i < dice.length; i++) dice[i] = new Die(sides);
    }

    /**
     * Rolls each <code>Die</code> in the array contained by the class, and prints out the value(s) of the dice.
     * Keep in mind that the caller will need to use methods of this class to view state changes.
     * @see Die
     */
    public void roll() {
        StringBuilder sb = new StringBuilder(Colorizer.LIGHT_GRAY + "Roll: " + Colorizer.RESET);
        for (Die d : dice) {
            d.roll();
            sb.append(Colorizer.LIGHT_PURPLE).append(d.getFace()).append(' ').append(Colorizer.RESET);
        }

        System.out.println(sb.toString());

    }

    /**
     * @return A boolean indicating whether the dice contained by the class all have the same face.
     */
    public boolean hasAllMatchingFaces() {
        for (int i = 1; i < dice.length; i++) if (dice[0].getFace() != dice[i].getFace()) return false;
        return true;
    }

    /**
     * @param n The face to be checked against the dice array
     * @return A boolean indicating whether one of the dice has the face {@code n}.
     */
    public boolean hasDieWithValue(int n) {
        for (Die d : dice) if (d.getFace() == n) return true;
        return false;
    }

    /**
     * @return The sum of the faces of the dice.
     */
    public int getSum() {
        int sum = 0;
        for (Die d : dice) sum += d.getFace();
        return sum;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Die d : dice) sb.append("---\n" + "|").append(d.getFace()).append("|\n---\n");

        return sb.toString();
    }
}
