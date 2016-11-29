package org.ananichev.exceptions;

/**
 * Created by leonid on 11/13/16.
 */
public class UnAuthorizedActionException extends Exception {
    @Override
    public String getMessage() {
        return "You should authorize with pinCode before accessing to money!";
    }
}
