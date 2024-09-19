public abstract class Transaction{
    protected  String accountNumber;
    protected Account account;
    protected double amount;

    public Transaction(String accountNumber, Account account, double amount) {
        this.accountNumber = accountNumber;
        this.account = account;
        this.amount = amount;
    }

    public abstract void execute();

}