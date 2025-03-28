public class BankAccount
{
    private int balanceUsd;
    private final String accountNumber;

    public BankAccount(String accountNumber, int i)
    {
        this.accountNumber = accountNumber;
        this.balanceUsd = 0;
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
        depositeAmount += balanceUsd;
    }

    public void withdraw(int withdrawAmount)
    {
        withdrawAmount -= balanceUsd;
    }

    public void transferToBank(BankAccount account2, String number, int i)
    {

    }
}
