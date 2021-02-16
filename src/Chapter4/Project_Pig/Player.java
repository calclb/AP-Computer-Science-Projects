package Chapter4.Project_Pig;

import Utils.Colorizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Player implements Comparable<Player> {

    private static final List<String> cpuNames = new ArrayList<>();

    static {
        cpuNames.addAll(Arrays.asList("Teeny", "Skipper", "Bean", "Button", "Rambo", "Drake", "Jet", "Dummy", "Psycho", "Bubba", "Dumbledore", "Ghoulie", "Sunny", "Bebe", "Turkey", "Moose", "Cricket", "Rockette", "Chili", "Pintsize", "Freak", "Joker", "Doobie", "Sassafras", "Candy", "Popeye", "Tootsie", "Toodles", "Pebbles", "Ash", "Buzz", "Punk", "Eagle", "Amethyst", "Cheeky", "Ducky", "Manatee", "Goblin", "Muffin", "Cookie", "Autumn", "Sassy", "Chubs", "Rainbow", "Rumplestiltskin", "Prego", "Einstein", "Loosetooth", "Smirk", "Peep", "Blondie", "Dreamey", "Pixie", "Hawk", "Fox", "Dud", "Dingo", "Amorcita", "Beetle", "Cotton", "Twinkly", "Amore", "Scarlet", "Boomhauer", "Donut", "Dimpling", "Biffle", "Con", "Cruella", "Weiner", "Sweetums", "Ginger", "Backbone", "Rosie", "Chico", "Lobster", "Buddy", "Speedy", "Stud", "Chuckles", "Conductor", "Pinata"));
    }

    // region - Immutable vars
    private final String nickname;
    private final DiceBag pairOfDice = new DiceBag(2);
    // endregion

    // region - Mutable vars
    private int points;
    private int stockpiledPoints;
    // endregion

    // region - Constructors
    public Player() {
        Random r = new Random();
        nickname = cpuNames.get(r.nextInt(cpuNames.size()));
    }

    public Player(String name) {
        nickname = name;
    }
    // endregion

    // region - Getters
    public String getNickname() {
        return nickname;
    }

    public int getPoints() {
        return points;
    }

    public int getStockpiledPoints() {
        return stockpiledPoints;
    }
    // endregion

    /**
     * "Banks" the points; i.e. resets the stockpiled points by adding them to the player's permanent points.
     * @return An integer that represents how many points the player has after banking their stockpiled points.
     */
    public int bankPoints() {
        int totalPoints = points += stockpiledPoints;
        stockpiledPoints = 0;
        return totalPoints;
    }

    /**
     * Runs a player's turn, which will continue until they bank their points or roll a 1.
     */
    public void runTurn() {
        pairOfDice.roll();

        if(pairOfDice.hasDieWithValue(1) && pairOfDice.hasAllMatchingFaces()) {
            points = 0;
            System.out.println(Colorizer.RED + nickname + " got snake eyes, and lost all of their points!" + Colorizer.RESET);
        }

        if(pairOfDice.hasDieWithValue(1)) {
            stockpiledPoints = 0;
            System.out.println(Colorizer.YELLOW + nickname + " rolled a 1 on one of their dice. Stockpiled points were lost, and their turn ends!" + Colorizer.RESET);
        }
        else {
            int sum = pairOfDice.getSum();
            System.out.println(nickname + " rolled and stockpiled " + Colorizer.BOLD + Colorizer.CYAN + sum + Colorizer.RESET + " points.");
            stockpiledPoints += sum;

            if(shouldBankPoints()) {
                System.out.println(nickname + " banked " + Colorizer.BOLD + Colorizer.GREEN + stockpiledPoints + Colorizer.RESET + " points, ending their turn." + Colorizer.RESET);
                bankPoints();
                PigGame.pause();
            }
            else {
                System.out.println(nickname + " decided to continue rolling!");
                PigGame.pause();
                runTurn();
            }
        }
    }

    /**
    * Determines if a Player should bank their points. By default, this method returns true when <code>sp >= 20 || p + sp >= 100</code>, where
    * `sp` is the stockpiled points and `p` is the banked points.
    * @implNote Protected visibility so that it can be overridden by children of the class (players will be prompted y/n to bank points).
    */
    protected boolean shouldBankPoints() {
        return stockpiledPoints >= 20 || points + stockpiledPoints >= PigGame.POINTS_TO_WIN;
    }

    // region - Overrides
    @Override
    public int compareTo(Player p) {
        return getPoints() - p.getPoints();
    }

    @Override
    public String toString() {
        return Colorizer.WHITE + nickname + Colorizer.RESET
                + Colorizer.LIGHT_GREEN + " (" + Colorizer.BOLD + points + Colorizer.RESET + Colorizer.LIGHT_GREEN + " pts)"
                + (stockpiledPoints > 0 ? Colorizer.RESET + Colorizer.LIGHT_PURPLE + " (" + stockpiledPoints + " stock)" : "") + Colorizer.RESET;
    }
    // endregion
}
