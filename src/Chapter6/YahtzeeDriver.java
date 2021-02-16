package Chapter6;

public class YahtzeeDriver {
    public static void main(String[] args) {
        Yahtzee yz = new Yahtzee();

        yz.rollAll();
        System.out.println(yz);

        yz.rollDiceOfIndexes(new int[]{1, 3, 4});
        System.out.println(yz);
    }
}
