package Chapter4;

public class DiceRace {

    public static void main(String[] args) {

        PairOfDice pd = new PairOfDice();
        PairOfDice pd2 = new PairOfDice();

        final int cap = 100;

        int runningSum = 0;
        int runningSum2 = 0;
        int rolls = 0;

        while(runningSum < cap && runningSum2 < cap)
        {
            pd.roll();
            pd2.roll();
            runningSum += pd.getSum();
            runningSum2 += pd2.getSum();
            rolls++;

            System.out.println("Roll " + rolls + "\t| First Pair: " + runningSum + "\t Second Pair: " + runningSum2);
        }

        System.out.println("The " + (runningSum > runningSum2 ? "first" : "second") + " pair of dice finished first with " + rolls + " rolls.");
    }


}
