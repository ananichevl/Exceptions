package org.ananichev;

import org.ananichev.data.Account;
import org.ananichev.data.AccountService;
import org.ananichev.mesinterface.Interface;
import org.ananichev.mesinterface.InterfaceImpl;
import org.ananichev.terminal.*;

import java.util.HashMap;

/**
 * Created by leonid on 11/13/16.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String, Account> accountHashMap = new HashMap<>();
        accountHashMap.put("Leonid", new Account(1234, "Leonid"));
        accountHashMap.put("Karim", new Account(1234, "Karim"));
        AccountService accountService = new AccountService(accountHashMap);
        Interface anInterface = new InterfaceImpl();
        MoneyValidator validator = new MoneyValidator(anInterface);
        PinValidator pinValidator = new PinValidator(accountService, anInterface);
        TerminalServer server = new TerminalServer();
        Terminal terminal = new TerminalImpl(validator, anInterface, pinValidator, server);
        terminal.checkAccountMoney(new Account(1233, "Leonid"));
        terminal.checkAccountMoney(new Account(1233, "Leonid"));
        terminal.checkAccountMoney(new Account(1233, "Leonid"));
        terminal.checkAccountMoney(new Account(1234, "Leonid"));
        try {
            Thread.sleep(3000);
            terminal.checkAccountMoney(new Account(1234, "Leonid"));
            terminal.checkAccountMoney(new Account(1234, "Karim"));
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        terminal.putMoney(new Account(1234, "Leonid"), 1004);
        terminal.getMoney(new Account(1234, "Leonid"), 100);
    }
}
