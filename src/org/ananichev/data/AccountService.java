package org.ananichev.data;

import java.util.HashMap;

/**
 * Created by leonid on 11/13/16.
 */
public class AccountService {
    private final HashMap<String, Account> accounts;

    public AccountService(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Account getByName(String name){
        return accounts.get(name);
    }


}
