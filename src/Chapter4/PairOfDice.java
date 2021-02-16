package Chapter4;

public class PairOfDice {

    private final Die d1;
    private final Die d2;

    public PairOfDice() {
        d1 = new Die();
        d2 = new Die();
    }

    public PairOfDice(int sides) {
        d1 = new Die(sides);
        d2 = new Die(sides);
    }

    public Die[] getDiceArray() {
        return new Die[]{d1, d2};
    }

    public void roll() {
        d1.roll();
        d2.roll();
    }

    public boolean hasMatchingFaces() {
        return d1.getFace() == d2.getFace();
    }

    public int getSum() {
        return d1.getFace() + d2.getFace();
    }

    public String toString() {
        String sd1 = "---\n" +
                "|" + d1.getFace() + "|\n---\n";

        String sd2 = "---\n" +
                "|" + d2.getFace() + "|\n---\n";

        return "Pair of dice: \n" + sd1 + sd2;
    }
}
