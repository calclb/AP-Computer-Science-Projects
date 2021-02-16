package Chapter6;

import java.text.NumberFormat;

public class Account
{
        private NumberFormat fmt = NumberFormat.getCurrencyInstance();
        private final double RATE = 0.035; // interest rate of 3.5%
        private int acctNumber;
        private double balance;
        private String name;

        public Account(String owner, int account, double initial)
        {
            name = owner;
            acctNumber = account;
            balance = initial;
        }

        public Account(String owner, int account)
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

        public double addInterest (double interest)
        {
            balance += (balance * interest);
            return balance;
        }

        public double getBalance ()
        {
            return balance;
        }

        public int getAccountNumber ()
        {
            return acctNumber;
        }

        private void setBalance(double balance) { this.balance = balance; }

        public void transferFunds(Account accountTo, double funds)
        {
            setBalance(getBalance() - funds);
            accountTo.setBalance(accountTo.getBalance() + funds);
        }

        public String toString ()
        {
            return ("[Account #" + acctNumber + "]\n\t- Name: " + name + "\n\t- Balance: " + fmt.format(balance));
        }

        public String format(String s) { return fmt.format(s); }
}
