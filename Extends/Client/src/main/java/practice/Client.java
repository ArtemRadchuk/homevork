package practice;

public abstract class Client {
    private double amount = 0;

    public void info(){
        System.out.println("Доступные операции:" + "\n" + "1. Показать баланс. " + "\n" + "2. Пополнить баланс. " + "\n" + "3. Снять со счета. ");
    }

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
