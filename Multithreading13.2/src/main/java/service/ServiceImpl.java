package service;

import domain.Bank;

import java.util.Locale;
import java.util.Scanner;

public class ServiceImpl implements Service{
    @Override
    public void startService(Bank bank){
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
    }
}
