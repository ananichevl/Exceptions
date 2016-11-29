package org.ananichev.exceptions;

/**
 * Created by leonid on 11/13/16.
 */
public class WrongPinCodeException extends Exception {
    @Override
    public String getMessage() {
        return "Your PinCode is incorrect! Try again!";
    }
}
