package Chapter6;
import Chapter4.Die;

public class Yahtzee
{
    private Die[] dice = new Die[5];

    public Yahtzee()
    {
        for(int i = 0; i < dice.length; i++) dice[i] = new Die();
    }

    public void rollAll()
    {
        for(Die d : dice) d.roll();
    }

    public void rollOne(int index)
    {
        dice[index].roll();
    }

    public void rollDiceOfIndexes(int[] nums)
    {
        for(int n : nums)
        {
            dice[n].roll();
            // System.out.println(dice[n].toString());
        }

        System.out.println();

        /*for(int i = 0; i < nums.length; i++)
        {
            dice[nums[i]].roll();
            System.out.println(dice[nums[i]].toString());
        }*/
    }

    public int getScore()
    {
        int total = 0;
        for(Die d : dice) total += d.getFace();
        return total;
    }

    @Override
    public String toString()
    {
        return "Yahtzee Score: " + getScore();
    }
}
