import java.util.ArrayList;
import java.util.List;

public class Bank
{
    private List<BankAccount> bankAccounts;


    public Bank()
    {
        bankAccounts = new ArrayList<BankAccount>();
    }
    public void addAccount(BankAccount newAccount)
    {
        bankAccounts.add(newAccount);
    }

    public BankAccount retrieveAccount(final String number)
    {
        for(BankAccount account : bankAccounts)
        {
            if(account.getAccountNumber().equals(number))
            {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public int totalBalanceUsd()
    {
        int total = 0;

        for(BankAccount account : bankAccounts)
        {
            total += account.getBalanceUsd();
        }
        return total;
    }
}
