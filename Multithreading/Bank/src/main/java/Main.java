public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account_1 = new Account();
        Account account_2 = new Account();
        Account account_3 = new Account();
        account_1.setMoney(120011);
        account_2.setMoney(122001);
        account_3.setMoney(582001);
        Bank bank = new Bank();
        bank.accounts.put("187", account_1);
        bank.accounts.put("188", account_2);
        bank.accounts.put("189", account_3);
        new transferThread("187","188",51000,bank).start();
        new transferThread("188","189",52000,bank).start();
    }
}
