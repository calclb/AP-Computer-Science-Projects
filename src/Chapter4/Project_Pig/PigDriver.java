package Chapter4.Project_Pig;


import Utils.Colorizer;

import java.util.Scanner;

public class PigDriver {
    public static void main(String[] args) {

        // although creating a new Scanner per call isn't particularly efficient, it isn't a big deal here.
        int humanPlayers = getIntByDialogue("How many human players? ", false);
        int compPlayers = getIntByDialogue("How many computer players? ", false);

        PigGame pg = new PigGame(humanPlayers, compPlayers);
        pg.play();
    }

    private static int getIntByDialogue(String prompt, boolean promptOnNewLine) {

        Scanner s = new Scanner(System.in);
        int num;
        while(true) {
            if (promptOnNewLine) System.out.println(prompt);
            else System.out.print(prompt);

            try {
                num = Integer.parseInt(s.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(Colorizer.RED + "Please enter a valid integer!" + Colorizer.RESET);
            }
        }
        return num;
    }
}
