package Chapter4.Project4_8;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;


public class StudentInfo
{
    private String firstName, lastName;
    private Address homeAddress, schoolAddress;
    private ArrayList<Double> testScores;
    private NumberFormat pf = NumberFormat.getPercentInstance();
    //-----------------------------------------------------------------
// Sets up this Student object with the specified initial values.
//-----------------------------------------------------------------
    public StudentInfo (String first, String last, Address home,
                        Address school)
    {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
    }

    public StudentInfo (String first, String last, Address home,
                        Address school, ArrayList<Double> testScores)
    {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
        this.testScores = testScores;
    }

    public void addTestScore(double score)
    {
        testScores.add(score);
    }

    public void setTestScore(int testNumber, double score)
    {
        if(testNumber <= 0 || testNumber > testScores.size()) throw new IllegalArgumentException();
        testScores.set(testNumber, score);
    }

    public double getTestScore(int testNumber)
    {
        return testScores.get(testNumber);
    }

    public double average()
    {
        double sum = 0;
        for (double testScore : testScores) sum += testScore;
        return sum / testScores.size();
    }

    //-----------------------------------------------------------------
// Returns this Student object as a string.
//-----------------------------------------------------------------
    public String toString()
    {
        String result;
        result = firstName + " " + lastName + "\n";
        result += "Home Address: " + homeAddress + "\n";
        result += "School Address: " + schoolAddress;
        result += "\nTest Scores: ";
        Iterator<Double> it = testScores.iterator();
        while(it.hasNext())
        {
            double val = it.next();
            result += pf.format(val) + (it.hasNext() ? ", " : "");
        }
        result += "\nAverage Score: " + pf.format(average());
        return result;
    }
}
