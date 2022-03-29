package practice;

public abstract class Client {
    double money = 0;

    public double getAmount() {
        return money;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            money = money + amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake < money) {
            money = money - amountToTake;
        }
    }
}
