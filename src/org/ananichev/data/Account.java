package org.ananichev.data;

/**
 * Created by leonid on 11/13/16.
 */
public class Account {

    private final Integer pin;
    private final String name;

    private boolean isLocked = false;
    private Integer money;
    private Integer attempts;

    public Account(Integer pin, String name) {
        this.pin = pin;
        this.name = name;
        this.money = 0;
        this.attempts = 0;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Integer getPin() {
        return pin;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
