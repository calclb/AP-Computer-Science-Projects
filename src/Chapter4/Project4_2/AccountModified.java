package Chapter4.Project4_2;

import java.text.NumberFormat;

// Project 4.2
public class AccountModified
{
    private NumberFormat fmt = NumberFormat.getCurrencyInstance();
    private final double RATE = 0.035; // interest rate of 3.5%
    private int acctNumber;
    private double balance;
    private String name;

    public AccountModified(String owner, int account, double initial)
    {
        name = owner;
        acctNumber = account;
        balance = initial;
    }

    // Overloaded constructor
    public AccountModified(String owner, int account)
    {
        name = owner;
        acctNumber = account;
        balance = 0d;
    }

    public double deposit (double amount)
    {
        if (amount < 0) // deposit value is negative
        {
            System.out.println ();
            System.out.println ("Error: Deposit amount is invalid.");
            System.out.println (acctNumber + " " + fmt.format(amount));
        }
        else
            balance = balance + amount;
        return balance;
    }

    public double withdraw (double amount, double fee)
    {
        amount += fee;
        if (amount < 0) // withdraw value is negative
        {
            System.out.println ();
            System.out.println ("Error: Withdraw amount is invalid.");
            System.out.println ("Account: " + acctNumber);
            System.out.println ("Requested: " + fmt.format(amount));
        }
        else
        if (amount > balance) // withdraw value exceeds balance
        {
            System.out.println ();
            System.out.println ("Error: Insufficient funds.");
            System.out.println ("Account: " + acctNumber);
            System.out.println ("Requested: " + fmt.format(amount));
            System.out.println ("Available: " + fmt.format(balance));
        }
        else
            balance = balance - amount;
        return balance;
    }

    public double addInterest ()
    {
        balance += (balance * RATE);
        return balance;
    }

    public double getBalance () { return balance; }
    public int getAccountNumber (){return acctNumber;}

    // New method
    public void transferFunds(AccountModified accountTo, double funds)
    {
        System.out.println("Attempting transaction: " + name + ", Account #" + acctNumber + " [" + fmt.format(funds) + "] -> Account #" + accountTo.getAccountNumber());
        withdraw(funds, 0d);
        if(funds <= balance) accountTo.deposit(funds);
    }

    public String toString ()
    {
        return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
    }

    public String format(double d) { return fmt.format(d); }
}