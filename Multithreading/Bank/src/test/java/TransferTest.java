
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


public class TransferTest {
    Account fromAcc = new Account();
    Account toAcc = new Account();

    @Test
    @DisplayName("Перевод 10000")
    public void transactionTest() throws InterruptedException {
        fromAcc.setAccNumber("111");
        fromAcc.setMoney(11000);
        toAcc.setAccNumber("222");
        toAcc.setMoney(0);
        Bank bank = new Bank();
        bank.accounts.put("111", fromAcc);
        bank.accounts.put("222", toAcc);
        bank.transfer("111", "222", 10000);
        Assertions.assertEquals(10000, bank.getBalance("222"));
        Assertions.assertEquals(1000, bank.getBalance("111"));
    }

    @Test
    @DisplayName("Блокирование счетов")
    public void accountBlockTest() throws InterruptedException {
        boolean fraud = false;
        fromAcc.setAccNumber("333");
        toAcc.setAccNumber("444");
        Bank bank = new Bank();
        bank.accounts.put("333", fromAcc);
        bank.accounts.put("444", toAcc);
        while (!fraud) {
            if (bank.isFraud(fromAcc.getAccNumber(), toAcc.getAccNumber(), 51000)) {
                fraud = true;
            }
        }
        Assertions.assertEquals(true, fraud);
    }
}
