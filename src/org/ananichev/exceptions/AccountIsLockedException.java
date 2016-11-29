package org.ananichev.exceptions;

import java.util.Date;

/**
 * Created by leonid on 11/13/16.
 */
public class AccountIsLockedException extends Exception {
    private final Date date;

    public AccountIsLockedException() {
        this.date = new Date();
    }

    @Override
    public String getMessage() {
        return "You have used 3 attempts. Your account is locked for " + (5 - ((new Date().getTime() - date.getTime()) / 1000)) + " sec!";
    }
}
