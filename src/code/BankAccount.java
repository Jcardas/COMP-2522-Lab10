public class BankAccount
{
    public static final int INIT_BALANCE_USD = 0;
    public static final int MINIMUM_BALANCE_USD = 0;
    private             int    balanceUsd;
    private final       String accountNumber;

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

    private void verifyAccountNumber(final String accountNumber)
    {
        if(accountNumber.isBlank())
        {
            throw new IllegalArgumentException("Account number cannot be blank");
        }
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public int getBalanceUsd()
    {
        return balanceUsd;
    }

    public void deposit(final int depositAmount)
    {
        if(depositAmount < MINIMUM_BALANCE_USD)
        {
            throw new IllegalArgumentException("Deposit value cannot be negative");
        }
        balanceUsd += depositAmount;
    }

    public void withdraw(final int withdrawAmount)
    {
        if(balanceUsd < withdrawAmount)
        {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balanceUsd -= withdrawAmount;
    }

    public void transferToBank(final BankAccount account2, final String accountNumber, final int amount)
    {
        if(accountNumber == null || accountNumber.isBlank())
        {
            throw new IllegalArgumentException("Account number cannot be blank");
        }
        if(!accountNumber.equals(this.accountNumber))
        {
            throw new IllegalArgumentException("Invalid Account Number");
        }

        this.withdraw(amount);
        account2.deposit(amount);
    }
}
