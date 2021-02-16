package Chapter6.Project6_10;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quiz
{
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(ArrayList<Question> qs) { questions.addAll(qs); }

    public void add(Question q) { questions.add(q); }

    public void giveQuiz(int qsToAsk) { giveQuiz(qsToAsk, Integer.MIN_VALUE, Integer.MAX_VALUE); }

    public void giveQuiz(int qsToAsk, int minComplexity, int maxComplexity) {
        ArrayList<Integer> validQuestionIndexes = getValidQuestions(minComplexity, maxComplexity);
        NumberFormat pf = NumberFormat.getPercentInstance();
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int correct = 0;

        if (qsToAsk > validQuestionIndexes.size() || qsToAsk < 0)
        {
            qsToAsk = validQuestionIndexes.size();
            System.out.println("Not enough questions within the requested range; defaulting to " + validQuestionIndexes.size());
        }

        for(int i = 0; i < qsToAsk; i++)
        {
            int sIndex = r.nextInt(validQuestionIndexes.size());
            Question q = questions.get(validQuestionIndexes.get(sIndex));

            System.out.println("Question #" + (i+1) + ": " + q.getQuestion());
            if(s.next().equalsIgnoreCase(q.getAnswer()))
            {
                System.out.println("Correct.");
                correct++;
            } else System.out.println("Incorrect. The answer was " + q.getAnswer());
            validQuestionIndexes.remove(sIndex);
        }
        System.out.println("\n\n[Score Summary]: \n\t- Score: " + pf.format((double) correct / qsToAsk) + "\n\t- Correct Responses: " + correct + "\n\t- Total Questions: " + qsToAsk);
    }

    private ArrayList<Integer> getValidQuestions(int minComplexity, int maxComplexity)
    {
        ArrayList<Integer> vcis = new ArrayList<>();
        for(int i = 0; i < questions.size(); i++)
        {
            Question q = questions.get(i);
            if(q.getComplexity() >= minComplexity && q.getComplexity() <= maxComplexity) vcis.add(i);
        }
        return vcis;
    }
}
