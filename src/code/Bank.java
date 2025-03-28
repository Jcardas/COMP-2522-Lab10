import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank that manages multiple bank accounts.
 * Provides functionality to add accounts, retrieve accounts, and track total balance.
 *
 * @author Justin Cardas
 * @author Nick Nepomuceno
 * @version 1.0
 */
public class Bank
{
    public static final int               INIT_BALANCE_USD = 0;
    private final       List<BankAccount> bankAccounts;

    private int totalBalanceUsd;

    public Bank()
    {
        bankAccounts    = new ArrayList<>();
        totalBalanceUsd = INIT_BALANCE_USD;
    }

    /**
     * Adds a new bank account to the bank.
     * @param newAccount the bank account to add
     */
    public void addAccount(final BankAccount newAccount)
    {
        bankAccounts.add(newAccount);
        totalBalanceUsd += newAccount.getBalanceUsd();
    }

    /**
     * Retrieves a bank account by account number.
     * @param accountNumber the account number to search for
     * @return the BankAccount associated with the given account number
     * @throws IllegalArgumentException if the account is not found
     */
    public BankAccount retrieveAccount(final String accountNumber)
    {
        for(BankAccount account : bankAccounts)
        {
            if(account.getAccountNumber().equals(accountNumber))
            {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    /**
     * Returns the total balance in USD across all bank accounts.
     * @return total balance in USD
     */
    public int totalBalanceUsd()
    {
        return totalBalanceUsd;
    }
}
