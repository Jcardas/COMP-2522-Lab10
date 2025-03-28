public class BankAccount
{
    private int balanceUsd;
    private final String accountNumber;

    public BankAccount(String accountNumber, int i)
    {
        this.accountNumber = accountNumber;
        this.balanceUsd = i;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public int getBalanceUsd()
    {
        return balanceUsd;
    }

    public void deposit(int depositeAmount)
    {
        balanceUsd += depositeAmount;
    }

    public void withdraw(int withdrawAmount)
    {
        if(balanceUsd < withdrawAmount)
        {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balanceUsd -= withdrawAmount;
    }

    public void transferToBank(BankAccount account2, String number, int amount)
    {
        this.withdraw(amount);
        account2.deposit(amount);
    }
}
