package practice;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void take(double amountToTake) {
        LocalDate dateOfTake = LocalDate.now();
        long period = ChronoUnit.MONTHS.between(lastIncome, dateOfTake);
        if (period >= 1) {
            super.take(amountToTake);
        }
    }

    @Override
    public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }
}
