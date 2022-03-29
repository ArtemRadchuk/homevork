package practice;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
      // CardAccount card = new CardAccount();
      // card.put(1000);
      // card.getAmount();
      // card.take(100);
      // card.getAmount();
      // BankAccount bank = new BankAccount();
      // bank.put(1000);
      // bank.getAmount();
      // bank.take(100);
      // bank.getAmount();
        LocalDate date1 = LocalDate.of(2022,02,20);
        LocalDate date = LocalDate.now();
        Period period = Period.between(date1,date);
        double a = ChronoUnit.DAYS.between(date1, date);
        System.out.println(period);
        System.out.println(a);
    }
}
