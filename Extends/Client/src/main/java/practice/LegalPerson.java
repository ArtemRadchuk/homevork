package practice;

public class LegalPerson extends Client {
    @Override
    public void take(double amountToTake) {
        super.take(amountToTake*1.01);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }
}
