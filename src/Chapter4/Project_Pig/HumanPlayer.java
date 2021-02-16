package Chapter4.Project_Pig;

import Utils.Colorizer;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String nickname) {
        super(nickname);
    }

    @Override
    protected boolean shouldBankPoints() {
        Scanner s = new Scanner(System.in);
        System.out.print(Colorizer.GRAY + "Do you want to roll again? Otherwise, you will bank your " + Colorizer.BOLD + Colorizer.CYAN + getStockpiledPoints() + Colorizer.RESET + Colorizer.GRAY + " stockpiled points. (y/n) " + Colorizer.RESET);
        return !s.next().equalsIgnoreCase("y");
    }

    public static HumanPlayer getHumanPlayerByDialogue() {
        Scanner s = new Scanner(System.in);
        System.out.print("What is your name? ");
        return new HumanPlayer(s.next());
    }

    @Override
    public String toString() {
        return Colorizer.GRAY_BACKGROUND + super.toString();
    }
}
