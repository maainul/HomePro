package com.mainul.HomePro.springSecurity.exception;

public class UnkownIdentifierException extends Exception{

    public UnkownIdentifierException() {
        super();
    }


    public UnkownIdentifierException(String message) {
        super(message);
    }


    public UnkownIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}
