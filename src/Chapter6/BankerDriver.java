package Chapter6;

import java.util.Scanner;

public class BankerDriver
{
    private static Bank bank = new Bank();
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        while(true)
        {
            System.out.println("L&L Bank Options:\n[0] Create account\n[1] View account details\n[2] Modify existing account\n[3] Add interest to accounts");
            int option = s.nextInt();
            switch(option)
            {
                case 0: doAccountCreation();
                    break;
                case 1: doGetAccountDetails();
                    break;
                case 2: doAccountModification();
                    break;
                case 3: doAddInterestToBankAccounts();
                    break;
                default: System.out.println("No options matched your input.\n");
            }
        }
    }

    private static void doAccountCreation()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter new account name: ");
        String name = s.next();

        System.out.print("Enter initial balance: $");
        double bal = s.nextDouble();

        System.out.print("Enter account number: #");
        int accNum = s.nextInt();

        bank.createAccount(name, accNum, bal);
        System.out.println("Account created.\n");
    }

    private static void doGetAccountDetails()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your account number: #");
        Account acc = bank.getAccount(s.nextInt());
        if(acc != null) System.out.println(acc + "\n");
        else System.out.println("That account could not be found.\n");
    }

    private static void doAccountModification()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your account number: #");
        Account acc = bank.getAccount(s.nextInt());

        if(acc == null) { System.out.println("That account could not be found.\n"); return; }

        System.out.print("Enter 'd' to deposit or 'w' to withdraw funds. ");
        String uinput = s.next();
        if(uinput.equalsIgnoreCase("d"))
        {
            System.out.print("Enter an amount to deposit: $");
            acc.deposit(s.nextDouble());
            System.out.println("Deposit complete.\n");
        }
        else if (uinput.equalsIgnoreCase("w"))
        {
            System.out.print("Enter an amount to deposit: $");
            bank.doWithdrawal(acc, s.nextDouble());
            System.out.println("Withdrawal complete.\n");
        }

        else System.out.println("Unrecognized input.\n");
    }

    private static void doAddInterestToBankAccounts()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter percent interest to add: ");
        double interest = s.nextDouble() / 100;

        bank.addInterestToAccounts(interest);
        System.out.println("Added interest.\n");
    }
}
