import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account_1 = new Account();
        Account account_2 = new Account();
        Account account_3 = new Account();
        Account account_4 = new Account();
        account_1.setMoney(120011);
        account_2.setMoney(122001);
        account_3.setMoney(582001);
        account_4.setMoney(12211);
        Bank bank = new Bank();
        bank.accounts.put("187", account_1);
        bank.accounts.put("188", account_2);
        bank.accounts.put("189", account_3);
        bank.accounts.put("190", account_4);
        while (true) {
            System.out.println("Выберите действие: TRANS - перевести деньги, BALANCE - показать баланс кошелька");
            String input = new Scanner(System.in).nextLine();
            if (input.equals("-1")) {
                break;
            }
            switch (input.toUpperCase(Locale.ROOT)) {
                case "TRANS":
                    System.out.println("Введите номер вашего кошелька");
                    String fromNumber = new Scanner(System.in).nextLine();
                    System.out.println("Введите кошелек на который отправить");
                    String toNumber = new Scanner(System.in).nextLine();
                    System.out.println("Введите количество отправляемых денег");
                    int amount = new Scanner(System.in).nextInt();
                    new transferThread(fromNumber, toNumber, amount, bank).start();
                    break;
                    case "BALANCE":
                    System.out.println("Введите номер вашего кошелька");
                    String  number = new Scanner(System.in).nextLine();
                    System.out.println(bank.getBalance(number));
                    break;
            }
        }
        /*new transferThread("187", "188", 51000, bank).start();
        new transferThread("188", "189", 52000, bank).start();*/
    }
}
