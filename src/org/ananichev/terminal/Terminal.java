package org.ananichev.terminal;

import org.ananichev.data.Account;

/**
 * Created by leonid on 11/12/16.
 */
public interface Terminal {
    void checkAccountMoney(Account account);

    void getMoney(Account account, Integer money);

    void putMoney(Account account, Integer money);
}
