import java.util.*;

public class Bank {

    public Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();
    public static List<String> blockedAccount = new ArrayList<>();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        System.out.println(getSumAllAccounts());
        long startTime = System.currentTimeMillis();
        for (String account : blockedAccount) {
            if (account.equals(fromAccountNum) || account.equals(toAccountNum)) {
                System.out.println("Аккаунт заблокирован!");
                break;
            }
        }

        if (accounts.get(fromAccountNum).getMoney() >= amount) {
            if (amount > 50000) {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                    blockedAccount.add(fromAccountNum);
                    blockedAccount.add(toAccountNum);
                    System.out.println("Аккаунт был заблокирован!");
                } else {
                    accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                    accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                }
            } else {

                accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
            }
        }
        long allTime  = System.currentTimeMillis() - startTime;
        System.out.println("Время транзакции: " + allTime);
        System.out.println("Перевод с аккаунта " + fromAccountNum + " на аккаунт "+ toAccountNum + " выполнен." + "\nВсего переведено: " + amount);
        System.out.println(getSumAllAccounts());
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {

        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (Map.Entry<String, Account> all : accounts.entrySet()) {
            sum = sum + all.getValue().getMoney();
        }
        return sum;
    }
}
