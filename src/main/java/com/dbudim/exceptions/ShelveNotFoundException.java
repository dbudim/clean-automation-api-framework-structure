package com.dbudim.exceptions;

public class ShelveNotFoundException extends RuntimeException {

    public ShelveNotFoundException(String name) {
        super("Shelve [" + name + "] not found");
    }

}
