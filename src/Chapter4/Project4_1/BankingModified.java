package Chapter4.Project4_1;

public class BankingModified {

        public static void main (String[] args)
        {
            AccountModified acct1 = new AccountModified("Ted Murphy", 72354, 102.56);
            AccountModified acct2 = new AccountModified("Anita Gomez", 69713, 40.00);

            System.out.println("Balance of account " + acct1.getAccountNumber() + ": " + acct1.format(acct1.getBalance()));
            System.out.println("Balance of account " + acct2.getAccountNumber() + ": " + acct1.format(acct2.getBalance()));

            acct1.transferFunds(acct2, 1000d);

            System.out.println("Balance of account " + acct1.getAccountNumber() + ": " + acct1.format(acct1.getBalance()));
            System.out.println("Balance of account " + acct2.getAccountNumber() + ": " + acct1.format(acct2.getBalance()));
    }
}
