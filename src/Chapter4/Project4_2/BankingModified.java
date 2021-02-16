package Chapter4.Project4_2;

public class BankingModified {

    public static void main (String[] args)
    {
        System.out.println("Creating new account; displaying balance.");
        AccountModified acct1 = new AccountModified("Ted Murphy", 72354);
        System.out.println("Balance of account " + acct1.getAccountNumber() + ": " + acct1.format(acct1.getBalance()));

    }
}
