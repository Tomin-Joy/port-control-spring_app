package com.e.wtc.Exceptions;

public class DuplicatePortException extends RuntimeException {

    public DuplicatePortException(String portName) {
        super("Port with name " + portName + " alredy exist");
    }
}
