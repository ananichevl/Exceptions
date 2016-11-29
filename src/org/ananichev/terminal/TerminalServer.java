package org.ananichev.terminal;

import org.ananichev.data.Account;
import org.ananichev.exceptions.NotEnoughMoneyException;

/**
 * Created by leonid on 11/13/16.
 */
public class TerminalServer {
    public int getAccountMoney(Account account) {
        return account.getMoney();
    }

    public void provideMoney(Account account, Integer money) throws NotEnoughMoneyException {
        if(account.getMoney() < money){
            throw new NotEnoughMoneyException();
        }
        account.setMoney(account.getMoney() - money);
    }

    public void acceptMoney(Account account, Integer money) {
        account.setMoney(account.getMoney() + money);
    }
}
