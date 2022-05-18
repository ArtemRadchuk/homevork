import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankInit initialization = new BankInit();
        initialization.init(bank);
        new Service().startService(bank);
    }
}

