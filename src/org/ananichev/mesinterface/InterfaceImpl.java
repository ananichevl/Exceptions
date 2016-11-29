package org.ananichev.mesinterface;

/**
 * Created by leonid on 11/15/16.
 */
public class InterfaceImpl implements Interface {
    @Override
    public void printMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
