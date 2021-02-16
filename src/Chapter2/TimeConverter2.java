package Chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

// Project 2.7
public class TimeConverter2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Seconds: ");
        int seconds = Integer.parseInt(br.readLine());

        System.out.print("Total time: " + parseInputIntoTime(seconds));
    }

    private static String parseInputIntoTime(int timeInSeconds) {
        String myFormat = "###,###.##";
        DecimalFormat df = new DecimalFormat(myFormat);

        int hours = timeInSeconds / 3600;
        int minutes = (timeInSeconds - (hours * 3600)) / 60;
        int seconds = (timeInSeconds - (hours * 3600) - (minutes * 60));
        return (df.format(hours) + " hours, " + df.format(minutes) + " minutes, and " + df.format(seconds) + " seconds.");
    }
}
