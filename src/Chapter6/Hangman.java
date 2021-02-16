package Chapter6;

import Utils.Colorizer;

import java.util.Set;
import java.util.*;

public class Hangman
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        List<String> keyList = new ArrayList<>(getPhraseMap().keySet());

        String phrase = keyList.get(r.nextInt(keyList.size()));
        String[] words = phrase.split(" ");
        String[] guess = words.clone();

        for(int i = 0; i < guess.length; i++)
        {
            StringBuilder newStr = new StringBuilder();
            for (int j = 0; j < guess[i].length(); j++) newStr.append('_');
            guess[i] = newStr.toString();
        }

        Set<Character> invalidChars = new HashSet<>();
        Set<Character> guessedChars = new HashSet<>();
        int incorrectGuesses = 0;
        int maxGuesses = 10;
        boolean isWordGuessed = false;
        char guessedChar = '_';

        while(maxGuesses > incorrectGuesses)
        {
            System.out.print("〉");
            for (String word : guess)
            {
                for (int j = 0; j < word.length(); j++)
                {
                    char c = word.charAt(j);
                    System.out.print((Character.toLowerCase(c) == Character.toLowerCase(guessedChar) ? Colorizer.BOLD + Colorizer.BLUE : "") + c + " " + Colorizer.RESET);
                }
                System.out.print("\t");
            }

            if (isWordGuessed) break;

            System.out.print(Colorizer.LIGHT_GRAY + "\nInvalid characters: ");
            for (int i = 0; i < invalidChars.size(); i++) System.out.print(Colorizer.CYAN + invalidChars.toArray()[i] + Colorizer.RESET + (invalidChars.size() - i - 1 == 0 ? "" : ", "));
            if (invalidChars.size() == 0) System.out.print(Colorizer.ITALIC + Colorizer.GRAY + "None" + Colorizer.RESET);
            System.out.print(Colorizer.LIGHT_GRAY + "\nIncorrect answers remaining: " + Colorizer.LIGHT_RED + (maxGuesses - incorrectGuesses) + Colorizer.RESET);

            System.out.print("\nGuess a character: ");
            guessedChar = s.next().charAt(0);

            if(guessedChars.contains(guessedChar))
            {
                System.out.println(Colorizer.YELLOW + Colorizer.ITALIC + "You already guessed that character.\n" + Colorizer.RESET);
                Colorizer.printDivider(80);
                System.out.println();
                continue;
            } else guessedChars.add(guessedChar);

            int matches = 0;

            assert words.length == guess.length;
            for (int i = 0; i < words.length; i++)
            {
                char[] guessChars = guess[i].toCharArray();
                char[] wordChars = words[i].toCharArray();
                for (int j = 0; j < wordChars.length; j++)
                {
                    if (Character.toLowerCase(guessedChar) == Character.toLowerCase(wordChars[j]))
                    {
                        guessChars[j] = wordChars[j];
                        matches++;
                    } else if(guessChars[j] != wordChars[j]) guessChars[j] = '_';

                }
                StringBuilder sb = new StringBuilder();
                for(char c : guessChars) sb.append(c);

                guess[i] = sb.toString();
            }

            for (int i = 0; i < words.length; i++)
                if (words[i].equals(guess[i])) isWordGuessed = true;
                else
                {
                    isWordGuessed = false;
                    break;
                }

            if (matches == 0)
            {
                incorrectGuesses++;
                invalidChars.add(guessedChar);
            }
            System.out.println(Colorizer.LIGHT_GRAY + "That character appeared " + Colorizer.BLUE + Colorizer.BOLD + matches + Colorizer.RESET + Colorizer.LIGHT_GRAY + (matches == 1 ? " time" : " times") + " in the phrase.\n" + Colorizer.RESET);
            Colorizer.printDivider(80);
            System.out.println();
        }

        if(isWordGuessed) System.out.println(Colorizer.GREEN + "\nYou correctly spelled out the phrase.\n" + formatPhrase(phrase));
        else System.out.println(Colorizer.RED + "\nYou have no incorrect guesses remaining. Better luck next time.\n" + formatPhrase(phrase));
    }

    public static Map<String, String> getPhraseMap()
    {
        Map<String, String> phrases = new HashMap<>();
        phrases.put("aberration", "a state or condition markedly different from the norm");
        phrases.put("pyrophoric", "capable of igniting spontaneously in air");
        phrases.put("desidurium", "an ardent longing, as for something lost");
        phrases.put("abditory", "a place you can disappear to");
        phrases.put("atelophobia", "the fear of imperfection");
        phrases.put("sequacious", "lacking originality of thought");
        phrases.put("kalopsia", "the delusion of things being more beautiful than they really are");
        phrases.put("rudeneja", "the way nature begins to feel like autumn");
        phrases.put("brumous", "filled with heavy clouds or fog, relating to cold or winter");
        phrases.put("logolepsy", "an obsession with words");
        phrases.put("palinoia", " the obsessive repetition of an act until it is perfect or mastered");
        phrases.put("squalid", "extremely dirty and unpleasant, destitute");
        phrases.put("gaze", "look steadily and intently");
        phrases.put("fanatical", "filled with excessive and single-minded zeal");
        phrases.put("strain", "force to make a strenuous effort");
        phrases.put("aberrant", "departing from an accepted standard");
        phrases.put("puzzling", "causing one to be perplexed");
        phrases.put("envy", "a feeling of discontented or resentful longing");
        phrases.put("imbibe", "drink, especially alcohol");
        phrases.put("prose", "written without metrical structure");
        phrases.put("scrawl", "write in a hurried or disorganized manner");
        phrases.put("abhor", "find repugnant");
        phrases.put("acquiesce", "agree or express agreement");
        phrases.put("alacrity", "liveliness and eagerness");
        phrases.put("avarice", "reprehensible acquisitiveness; insatiable desire for wealth");
        phrases.put("brusque", "rudely abrupt or blunt in speech or manner");
        phrases.put("cajole", "influence or urge by gentle urging, caressing, or flattering");
        phrases.put("confidant", "someone to whom private matters are told");
        phrases.put("connive", "form intrigues (for) in an underhand manner");
        phrases.put("decry", "express strong disapproval of");
        phrases.put("deferential", "showing courteous regard for people’s feelings");
        phrases.put("demure", "shy or modest, often in a playful or provocative way");
        phrases.put("despot", "a cruel and oppressive dictator");
        phrases.put("embezzle", "appropriate fraudulently to one’s own use");
        phrases.put("enmity", "a state of deep-seated ill-will");
        phrases.put("erudite", "having or showing profound knowledge");
        phrases.put("flabbergasted", "as if struck dumb with astonishment and surprise");
        phrases.put("furtive", "secret and sly or sordid");
        phrases.put("gratuitous", "unnecessary and unwarranted");
        phrases.put("haughty", "having or showing arrogant superiority");
        phrases.put("impeccable", "without fault or error");
        phrases.put("impertinent", "improperly forward or bold");
        phrases.put("impudent", "improperly forward or bold");
        phrases.put("indolent", "disinclined to work or exertion");
        phrases.put("insular", "narrowly restricted in outlook or scope");
        phrases.put("intrepid", "invulnerable to fear or intimidation");
        phrases.put("inveterate", "stubbornly established by habit");
        phrases.put("knell", "the solemn sound of a bell, often indicating a death");
        phrases.put("lithe", "graceful, flexible, supple");
        phrases.put("lurid", "ghastly, sensational");
        phrases.put("maxim", "a common saying expressing a principle of conduct");
        phrases.put("modicum", "a small amount of something");
        phrases.put("nadir", "the lowest point of something");
        phrases.put("obsequious", "excessively compliant or submissive");
        phrases.put("penchant", "a tendency, partiality, preference");
        phrases.put("predilection", "a preference or inclination for something");
        phrases.put("rife", "abundant");
        phrases.put("salient", "significant, conspicuous");
        phrases.put("staid", "sedate, serious, self-restrained");
        phrases.put("sycophant", "one who flatters for self-gain");
        phrases.put("taciturn", "not inclined to talk");
        phrases.put("umbrage", "resentment, offence");
        phrases.put("venerable", "deserving of respect because of age or achievement");
        phrases.put("vociferous", "loud, boisterous");
        phrases.put("zenith", "the highest point, culminating point");
        phrases.put("odious", "hateful");
        phrases.put("ignominious", "deserving or causing public disgrace or shame");
        phrases.put("intercalate", "interpolate an intercalary period in a calendar");
        phrases.put("mnemonic", "a device such as a pattern of letters that assists in remembering something");
        return phrases;
    }

    private static String formatPhrase(String key) { return Colorizer.LIGHT_GRAY + "〉" + Colorizer.REVERSE + key + Colorizer.RESET + ": " + Colorizer.ITALIC + getPhraseMap().get(key) + Colorizer.RESET; }
}
