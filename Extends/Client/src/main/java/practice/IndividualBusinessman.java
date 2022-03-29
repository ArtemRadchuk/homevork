package practice;

public class IndividualBusinessman extends Client {
    @Override
    public void put(double amountToPut) {
        int minPut = 1000;
        if (amountToPut < minPut) {
            super.put((amountToPut / 100) * 99);
        } else if (amountToPut >= minPut) {
            super.put((amountToPut / 100) * 99.5);
        }
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake);
    }
}
