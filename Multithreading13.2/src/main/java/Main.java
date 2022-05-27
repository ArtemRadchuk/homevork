import domain.Bank;

import service.BankInitImpl;
import service.ServiceImpl;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankInitImpl initialization = new BankInitImpl();
        initialization.init(bank);
        new ServiceImpl().startService(bank);
    }
}

