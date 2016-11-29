package org.ananichev.terminal;

import org.ananichev.data.Account;
import org.ananichev.data.AccountService;
import org.ananichev.exceptions.AccountIsLockedException;
import org.ananichev.exceptions.WrongPinCodeException;
import org.ananichev.mesinterface.Interface;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by leonid on 11/13/16.
 */
public class PinValidator {
    private HashMap<Account, AccountIsLockedException> locked = new HashMap<>();

    private final AccountService accountService;
    private final Interface anInterface;

    public PinValidator(AccountService accountService, Interface anInterface) {
        this.accountService = accountService;
        this.anInterface = anInterface;
    }

    public boolean checkPinCode(Integer pin, String name) {
        try{
            Account acc = accountService.getByName(name);
            if(acc.isLocked()){
                throw locked.get(acc);
            }
            if(!acc.getPin().equals(pin)){
                if(acc.getAttempts() < 2){
                    acc.setAttempts(acc.getAttempts() + 1);
                }else {
                    acc.setAttempts(acc.getAttempts() + 1);
                    acc.setLocked(true);
                    locked.put(acc, new AccountIsLockedException());
                    Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            unLockAccount(acc, t);
                        }
                    }, 5000);
                }
                throw new WrongPinCodeException();
            }else {
                return true;
            }

        }catch (AccountIsLockedException e){
            anInterface.printMessage(e);
            return false;
        }catch (WrongPinCodeException e){
            anInterface.printMessage(e);
            return false;
        }
    }

    private void unLockAccount(Account account, Timer t){
        account.setLocked(false);
        account.setAttempts(0);
        t.cancel();
    }
}
