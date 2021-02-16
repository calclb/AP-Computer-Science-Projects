package Chapter6;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Bank
{
    private int customers = 30;
    private int lastAddedIndex = 0;
    private Account[] accounts;
    private double withdrawalFee = 0;
    NumberFormat fmt = DecimalFormat.getCurrencyInstance();

    public Bank()
    {
        accounts = new Account[customers];
    }

    public Bank(Account[] accs)
    {
        accounts = accs;
        lastAddedIndex = accs.length;
    }

    public void doWithdrawal(Account acc, double amt)
    {
        acc.withdraw(amt, withdrawalFee);
        System.out.println("Withdrew " + fmt.format(amt) + (withdrawalFee > 0 ? " and charged a fee of " + fmt.format(withdrawalFee) : "")
                + "; remaining balance: " + fmt.format(acc.getBalance()));
    }

    public void doDeposit(Account acc, double amt)
    {
        acc.deposit(amt);
        System.out.println("Deposited " + fmt.format(amt) + "; new balance: " + fmt.format(acc.getBalance()));
    }

    public Account getAccountByIndex(int index) { return accounts[index]; }

    public Account getAccount(int acctNumber)
    {
        for(Account acc : accounts) if(acc != null && acc.getAccountNumber() == acctNumber) return acc;
        return null;
    }

    public void createAccount(String owner, int accountNumber, double initial)
    {
        for(Account acc : accounts) if(acc != null && acc.getAccountNumber() == accountNumber)
        {
            System.out.println("That account number was already taken.");
            return;
        }
        accounts[lastAddedIndex + 1] = new Account(owner, accountNumber, initial);
        lastAddedIndex++;
    }

    public void addInterestToAccounts()
    {
        for(Account acc : accounts) if(acc != null) acc.addInterest();
    }

    public void addInterestToAccounts(double interest)
    {
        for(Account acc : accounts) if(acc != null) acc.addInterest(interest);
    }

}
