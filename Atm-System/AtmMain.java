public class AtmMain {
    public static void main(String[] args){
        BankingService bankService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser(595200);
        ATM atm = new ATM(bankService, cashDispenser);

        bankService.createAccount("PNB56978", 10056);
        bankService.createAccount("PNB56978", 5000);

        Card card = new Card("PNB56978", "5963");
        atm.authenticateUser(card);

        double balance = atm.checkBalance("PNB56978");
        System.out.println("Account balance: " + balance);

        atm.withdrawCash("PNB56978", 500.0);
        atm.depositCash("PNB56978", 200.0);

        balance = atm.checkBalance("PNB56978");
        System.out.println("Updated account balance: " + balance);

    }
}
