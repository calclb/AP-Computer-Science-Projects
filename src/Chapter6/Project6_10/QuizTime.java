package Chapter6.Project6_10;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizTime {

    public static void main(String[] args)
    {
        System.out.println("[Quiz 1] - Simply shows the functionality of the quiz");
        Quiz quiz = new Quiz(getDefaultQuestions());
        Scanner s = new Scanner(System.in);
        System.out.print("How many questions? ");
        quiz.giveQuiz(s.nextInt());


        // Demonstrate same quiz, but with min and max complexity bound
        System.out.println("\n\n[Quiz 2] - Demonstrates complexity filter");
        System.out.print("State a minimum complexity level: ");
        int minComplexity = s.nextInt();
        System.out.print("State a maximum complexity level: ");
        int maxComplexity = s.nextInt();
        System.out.print("How many questions? ");
        quiz.giveQuiz(s.nextInt(), minComplexity, maxComplexity);
    }

    private static ArrayList<Question> getDefaultQuestions()
    {
        ArrayList<Question> qs = new ArrayList<>();
        qs.add(new Question("What is 1 + 1?", "2"));
            qs.get(0).setComplexity(1);
        qs.add(new Question("What is 3 * 5?", "15"));
            qs.get(1).setComplexity(10);
        qs.add(new Question("What is 10 / 3?", "3"));
            qs.get(2).setComplexity(40);
        qs.add(new Question("What is 10 / (double)1?", "10.0"));
            qs.get(3).setComplexity(40);
        qs.add(new Question("What primitive data type represents a character?", "char"));
            qs.get(4).setComplexity(35);
        qs.add(new Question("What is the answer to the universe, and everything?", "42"));
            qs.get(5).setComplexity(100);
        qs.add(new Question("What is the lowest index of arrays?", "0"));
            qs.get(6).setComplexity(30);
        qs.add(new Question("What is the object representing me?", "String"));
            qs.get(7).setComplexity(45);
        qs.add(new Question("Are Arrays immutable (y/n)?", "y"));
            qs.get(8).setComplexity(60);
        qs.add(new Question("What reference do uninitialized objects point to?", "null"));
            qs.get(9).setComplexity(70);
        return qs;
    }
}
