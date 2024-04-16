package com.dbudim.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String name) {
        super("Book '" + name + "' not found");
    }

}
