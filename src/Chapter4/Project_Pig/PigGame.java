package Chapter4.Project_Pig;

import Utils.Colorizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PigGame {

    public static final int MIN_PLAYERS = 2;
    public static final int POINTS_TO_WIN = 100;

    private final List<Player> players = new ArrayList<>();

    public PigGame(int humanPlayers, int compPlayers) {
        for (int i = 0; i < humanPlayers; i++) players.add(HumanPlayer.getHumanPlayerByDialogue());
        for (int i = 0; i < compPlayers; i++) players.add(new Player());

        // Populate players list until it reaches the minimum player requirement
        while(players.size() < MIN_PLAYERS) players.add(new Player());
    }

    public void play() {

        printAllPlayerScores();

        winLogicLoop: while (!hasPlayerExceededWinThreshold()) {
            for (Player p : players) {
                System.out.println("\n" + (p instanceof HumanPlayer ? Colorizer.REVERSE : Colorizer.BOLD) + p.getNickname() + "'s turn!" + Colorizer.RESET);
                p.runTurn();
                if (p.getPoints() > POINTS_TO_WIN) break winLogicLoop;
            }

            printAllPlayerScores();
        }

        // At this point, at least one player won; order list to display scores.
        printAllPlayerScores(true);
    }

    private void printAllPlayerScores() {
        printAllPlayerScores(false);
    }

    private void printAllPlayerScores(boolean crownLeader) {

        List<Player> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort(Collections.reverseOrder(Player::compareTo));

        System.out.println("\n" + Colorizer.getDivider(10) + Colorizer.RESET + "Standings" + Colorizer.getDivider(10));
        for (int i = 0; i < sortedPlayers.size(); i++) {
            System.out.println((crownLeader && i == 0 ? Colorizer.BOLD + Colorizer.REVERSE + Colorizer.YELLOW + "\uD83D\uDD31 WINNER!" + Colorizer.RESET : (i+1) + ".") + " " + sortedPlayers.get(i));
        }
        System.out.println(Colorizer.getDivider(29));
    }

    private boolean hasPlayerExceededWinThreshold() {
        for (Player p : players) if (p.getPoints() > POINTS_TO_WIN) return true;
        return false;
    }

    public static void pause() {

        try {
            Thread.sleep(250);
        } catch(InterruptedException ignored) {}
    }
}
