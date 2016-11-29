package org.ananichev.exceptions;

/**
 * Created by leonid on 11/13/16.
 */
public class IncorrectValueException extends Exception {
    @Override
    public String getMessage() {
        return "Value should be multiple of 100!";
    }
}
