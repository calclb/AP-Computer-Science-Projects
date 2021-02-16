package Chapter4.Project4_4;

import Chapter4.PairOfDice;

public class BoxCars {
    public static void main(String[] args) {
        final int maxRolls = 1000;
        final int numToFind = 6;
        int boxcars = 0;

        PairOfDice pairOfDice = new PairOfDice();

        for(int i = 0; i < maxRolls; i++)
        {
            pairOfDice.roll();

            if(pairOfDice.hasMatchingFaces() && pairOfDice.getSum() == numToFind * pairOfDice.getDiceArray().length)
            {
                boxcars++;
                System.out.println("Boxcar #" + boxcars + " found on roll " + i + "!");
                for(int d = 0; d < pairOfDice.getDiceArray().length; d++) System.out.println("\tDie #" + (d + 1) + ": " + pairOfDice.getDiceArray()[d].getFace());
            }

        }

        boolean isSingular = boxcars == 1;
        System.out.println("There " + (isSingular ? "was" : "were") + " " + boxcars + " boxcar" + (isSingular ? "" : "s") + " in " + maxRolls + " roll" + (maxRolls == 1 ? "" : "s") + ".");
    }
}
