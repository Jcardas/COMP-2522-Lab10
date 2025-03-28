/**
 * Represents a bank account with an account number and balance.
 * Provides deposit, withdrawal, and transfer functionalities.
 *
 * @author Justin Cardas
 * @author Nick Nepomuceno
 * @version 1.0
 */
public class BankAccount
{
    public static final int    INIT_BALANCE_USD    = 0;
    public static final int    MINIMUM_BALANCE_USD = 0;
    private             int    balanceUsd;
    private final       String accountNumber;

    /**
     * Creates a bank account with a specified account number and initial balance.
     *
     * @param accountNumber the unique account identifier
     * @param amountUsd     the initial balance in USD
     * @throws IllegalArgumentException if the account number is invalid
     */
    public BankAccount(final String accountNumber, final int amountUsd)
    {
        verifyAccountNumber(accountNumber);

        this.accountNumber = accountNumber;
        this.balanceUsd    = amountUsd;
    }

    // Overloaded constructor for account with 0 dollars.
    public BankAccount(final String accountNumber)
    {
        verifyAccountNumber(accountNumber);
        this.accountNumber = accountNumber;

        this.balanceUsd = INIT_BALANCE_USD;
    }

    /*
    Verifies the account number doesn't contain special characters
    or is blank.
     */
    private void verifyAccountNumber(final String accountNumber)
    {
        if(accountNumber.isBlank())
        {
            throw new IllegalArgumentException("Account number cannot be blank");
        }

        if(!accountNumber.matches("[a-zA-Z0-9]+"))
        {
            throw new IllegalArgumentException("Account number cannot contain special characters");
        }
    }

    /**
     * @return the account number of this bank account
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * @return the balance of this bank account
     */
    public int getBalanceUsd()
    {
        return balanceUsd;
    }

    /**
     * Deposits a specified amount into the account.
     *
     * @param depositAmount the amount to deposit
     * @throws IllegalArgumentException if the deposit amount is negative
     */
    public void deposit(final int depositAmount)
    {
        if(depositAmount < MINIMUM_BALANCE_USD)
        {
            throw new IllegalArgumentException("Deposit value cannot be negative");
        }
        balanceUsd += depositAmount;
    }

    /**
     * Withdraws a specified amount from the account.
     *
     * @param withdrawAmount the amount to withdraw
     * @throws IllegalArgumentException if the withdrawal exceeds the balance
     */
    public void withdraw(final int withdrawAmount)
    {
        if(balanceUsd < withdrawAmount)
        {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balanceUsd -= withdrawAmount;
    }

    /**
     * Transfers a specified amount to another bank account.
     *
     * @param account2      the recipient bank account
     * @param accountNumber the account number of the sender (must match)
     * @param amount        the amount to transfer
     * @throws IllegalArgumentException if the account number is invalid or the balance is insufficient
     */
    public void transferToBank(final BankAccount account2, final String accountNumber, final int amount)
    {
        if(accountNumber == null || accountNumber.isBlank())
        {
            throw new IllegalArgumentException("Account number cannot be blank");
        }
        if(!accountNumber.equals(this.accountNumber))
        {
            throw new IllegalArgumentException("Invalid account number");
        }

        this.withdraw(amount);
        account2.deposit(amount);
    }

    @Override
    public String toString()
    {
        return "BankAccount{" + "balanceUsd=" + balanceUsd + ", accountNumber=" + accountNumber + '}';
    }
}
