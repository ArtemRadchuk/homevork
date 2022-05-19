package service;

import domain.Account;
import domain.Bank;

public class BankInitImpl implements BankInit {

    @Override
    public Bank init(Bank bank){
        Account account_1 = new Account();
        Account account_2 = new Account();
        Account account_3 = new Account();
        Account account_4 = new Account();
        account_1.setMoney(120011);
        account_2.setMoney(122001);
        account_3.setMoney(582001);
        account_4.setMoney(12211);
        bank.accounts.put("187", account_1);
        bank.accounts.put("188", account_2);
        bank.accounts.put("189", account_3);
        bank.accounts.put("190", account_4);
        return bank;
    }
}
