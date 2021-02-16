package Chapter3;

import Utils.Colorizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Miniquiz {

    private static int correctAnswers = 0;
    private static int questionsAnswered = 0;
    private static ArrayList<String> questions = new ArrayList<>();
    private static ArrayList<Integer> usedQuestionIndexes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        addQuestionsToList(questions);
        questions.trimToSize();

        System.out.print("How many questions (" + questions.size() + " total available questions)? ");
        int quizSize = Integer.parseInt(getResponse());

        System.out.println("Let the miniquiz begin.");
        doQuiz(quizSize);
    }

    private static void doQuiz(int numberOfQuestions) throws IOException {

        NumberFormat pf = NumberFormat.getPercentInstance(Locale.US);

        for(int i = 0; (i < numberOfQuestions) && (i < questions.size()); i++)
        {
            if(matchAnswerWith(askUniqueQuestion(questions, usedQuestionIndexes), getResponse()))
            {
                System.out.println("Correct.");
                correctAnswers++;
            } else System.out.println("Incorrect.");
            questionsAnswered++;
        }

        System.out.println("You answered " + correctAnswers + " of " + questionsAnswered + " questions correctly. (" + Colorizer.GREEN + pf.format((double)correctAnswers/questionsAnswered) + Colorizer.RESET + ")");
    }

    private static boolean matchAnswerWith(int questionIndex, String response) {
        boolean isAnswerCorrect = false;

        switch(questionIndex)
        {
            case 0:
                isAnswerCorrect = response.equals("2003");
                break;
            case 1:
                isAnswerCorrect = response.equalsIgnoreCase("true") || response.equalsIgnoreCase("false");
                break;
            case 2:
                isAnswerCorrect = response.contains("'");
                break;
            case 3:
                isAnswerCorrect = response.equals("32");
                break;
            case 4:
                isAnswerCorrect = response.equals("System.in");
                break;
            case 5:
                isAnswerCorrect = response.equalsIgnoreCase("no");
                break;
            case 6:
                isAnswerCorrect = response.equalsIgnoreCase("yes");
                break;
            case 7:
                isAnswerCorrect = response.contains("(String answer) {") && response.contains("boolean") && !response.contains("void");
                break;
            default:
                System.out.println(Colorizer.RED + "[!] No key was found for the question being matched.");
                break;
        }
        return isAnswerCorrect;
    }

    private static void addQuestionsToList(ArrayList<String> al) {
        al.add(0, "In what year was I born?");
        al.add(1, "List a possible value of booleans:");
        al.add(2, "What character do we use to surround char variables?");
        al.add(3, "How many bits worth of numbers can an integer value store?");
        al.add(4, "What argument does the Scanner class take in its constructor in order to read user input from the console?");
        al.add(5, "Are Strings mutable?");
        al.add(6, "Does the body of if statements require surrounding braces assuming they span two or more lines of code?");
        al.add(7, "Enter a valid method header (including its opening brace) in the following line which accepts a parameter named 'answer' of type String and returns a boolean:");
        // ... and so on
    }

    private static int askUniqueQuestion(ArrayList<String> questions, ArrayList<Integer> blacklist)
    {
        Random r = new Random();
        int index = r.nextInt(questions.size());

        while(blacklist.contains(index))
        {
            //System.out.println(ANSI_RED + "[!] Blacklist contains index of " + index + "; selecting new value.");
            index = r.nextInt(questions.size());
        }

        System.out.print(Colorizer.BLUE + "Question " + (questionsAnswered + 1) + "  ➔  " + Colorizer.WHITE + questions.get(index) + " " + Colorizer.RESET);
        blacklist.add(index);

        return index;
    }

    private static String getResponse() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}