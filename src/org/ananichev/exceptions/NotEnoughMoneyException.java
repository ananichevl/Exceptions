package org.ananichev.exceptions;

/**
 * Created by leonid on 11/29/16.
 */
public class NotEnoughMoneyException extends Exception {
    @Override
    public String getMessage() {
        return "Not enough money";
    }
}
