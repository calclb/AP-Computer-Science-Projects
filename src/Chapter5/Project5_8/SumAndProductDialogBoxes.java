package Chapter5.Project5_8;

import javax.swing.*;
import java.text.DecimalFormat;

public class SumAndProductDialogBoxes extends JApplet
{
    public static void main(String[] args)
    {

        DecimalFormat df = new DecimalFormat("#.##");

        double num1, num2;
        int doAgain;
        do
        {
            try
            {
                String option1 = JOptionPane.showInputDialog("Enter the first integer:");
                if(option1 == null) return;
                num1 = Double.parseDouble(option1);
                String option2 = JOptionPane.showInputDialog("Enter the second integer:");
                if(option2 == null) return;
                num2 = Double.parseDouble(option2);
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "The entered input was not valid.");
                doAgain = JOptionPane.YES_OPTION;
                continue;
            }
            double sum = num1 + num2;
            double product = num1 * num2;

            JOptionPane.showMessageDialog(null,df.format(num1) + " + " + df.format(num2) + " = " + df.format(sum));
            JOptionPane.showMessageDialog(null,df.format(num1) + " * " + df.format(num2) + " = " + df.format(product));

            doAgain = JOptionPane.showConfirmDialog(null, "Perform again?");

        } while(doAgain == JOptionPane.YES_OPTION);
    }
}
