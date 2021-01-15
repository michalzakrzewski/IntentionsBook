package com.zakrzewski.intentionsbook.exceptions;

public class EmptyLoginException extends RuntimeException {

    public EmptyLoginException() {
        super("Login cannot be empty!");
    }
}
