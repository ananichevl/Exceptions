package org.ananichev.terminal;

import org.ananichev.data.Account;
import org.ananichev.exceptions.NotEnoughMoneyException;
import org.ananichev.exceptions.UnAuthorizedActionException;
import org.ananichev.mesinterface.Interface;

/**
 * Created by leonid on 11/13/16.
 */
public class TerminalImpl implements Terminal {

    private final MoneyValidator validator;

    private final Interface anInterface;

    private final PinValidator pinValidator;

    private final TerminalServer terminalServer;

    public TerminalImpl(MoneyValidator validator, Interface anInterface, PinValidator pinValidator, TerminalServer terminalServer) {
        this.validator = validator;
        this.anInterface = anInterface;
        this.pinValidator = pinValidator;
        this.terminalServer = terminalServer;
    }

    @Override
    public void checkAccountMoney(Account account) {
        try {
            if(pinValidator.checkPinCode(account.getPin(), account.getName())){
                System.out.println(terminalServer.getAccountMoney(account));
            }else{
                throw new UnAuthorizedActionException();
            }
        }catch (UnAuthorizedActionException e){
            anInterface.printMessage(e);
        }
    }

    @Override
    public void getMoney(Account account, Integer money) {
        try {
            if(pinValidator.checkPinCode(account.getPin(), account.getName())){
                if(validator.validateMoney(money)){
                    terminalServer.provideMoney(account, money);
                }
            }else{
                throw new UnAuthorizedActionException();
            }
        }catch (UnAuthorizedActionException | NotEnoughMoneyException e){
            anInterface.printMessage(e);
        }
    }

    @Override
    public void putMoney(Account account, Integer money) {
        try {
            if(pinValidator.checkPinCode(account.getPin(), account.getName())){
                if(validator.validateMoney(money)){
                    terminalServer.acceptMoney(account, money);
                }
            }else{
                throw new UnAuthorizedActionException();
            }
        }catch (UnAuthorizedActionException e){
            anInterface.printMessage(e);
        }
    }
}
