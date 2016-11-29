package org.ananichev.terminal;

import org.ananichev.exceptions.IncorrectValueException;
import org.ananichev.mesinterface.Interface;

/**
 * Created by leonid on 11/13/16.
 */
public class MoneyValidator {
    private final Interface anInterface;

    public MoneyValidator(Interface anInterface) {
        this.anInterface = anInterface;
    }

    public boolean validateMoney(Integer money){
        try{
            if(money % 100 != 0){
                throw new IncorrectValueException();
            }else {
                return true;
            }
        }catch (IncorrectValueException e){
            anInterface.printMessage(e);
            return false;
        }
    }
}
