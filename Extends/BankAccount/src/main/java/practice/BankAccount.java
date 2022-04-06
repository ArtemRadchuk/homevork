package practice;

public class BankAccount {
    private double amount = 0;

    public double getAmount() {
        System.out.println(amount);
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount = amount + amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake < amount) {
            amount = amount - amountToTake;
        }
    }
}
