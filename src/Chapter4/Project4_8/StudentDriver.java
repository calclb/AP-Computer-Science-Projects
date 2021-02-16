package Chapter4.Project4_8;

import java.util.ArrayList;

public class StudentDriver {
    public static void main(String[] args) {
        ArrayList<Double> scores = new ArrayList<>();
        scores.add(.91);
        scores.add(.89);
        scores.add(.84);

        Address home = new Address("Main St", "Joeville", "JO", 10101);
        Address school = new Address("Academics St", "Schoolville", "SH", 51010);
        StudentInfo student = new StudentInfo("Joe", "Smith", home, school, scores);

        System.out.println(student);
    }
}
