public class transferThread extends Thread {
    String fromAccountNum;
    String toAccountNum;
    long amount;
    Bank bank;

    public transferThread(String fromAccountNum, String toAccountNum, long amount, Bank bank) {
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
        this.amount = amount;
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            bank.transfer(fromAccountNum,toAccountNum,amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
