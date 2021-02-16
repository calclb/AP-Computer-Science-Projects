package Chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

// Project 2.6
public class TimeConverter {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String myFormat = "###,###.##";
        DecimalFormat df = new DecimalFormat(myFormat);

        System.out.print("Hours: ");
        int hours = Integer.parseInt(br.readLine());

        System.out.print("Minutes: ");
        int minutes = Integer.parseInt(br.readLine());

        System.out.print("Seconds: ");
        int seconds = Integer.parseInt(br.readLine());
        seconds += (minutes * 60) + (hours * 3600);

        System.out.print("Total time in seconds: " + df.format(seconds));
    }
}
