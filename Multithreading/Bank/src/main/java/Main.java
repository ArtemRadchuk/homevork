public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account_1 = new Account();
        Account account_2 = new Account();
        Account account_3 = new Account();
        account_1.setMoney(1200);
        account_2.setMoney(12200);
        account_3.setMoney(58200);
        Bank bank = new Bank();
        bank.accounts.put("187", account_1);
        bank.accounts.put("188", account_2);
        bank.accounts.put("189", account_3);
        bank.transfer("189", "187", 50500);
        bank.transfer("188", "189", 500);
        

    }
}
