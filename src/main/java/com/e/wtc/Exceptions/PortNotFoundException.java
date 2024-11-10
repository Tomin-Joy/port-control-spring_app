package com.e.wtc.Exceptions;

public class PortNotFoundException extends RuntimeException {

    public PortNotFoundException(int portId) {
        super("Port not found with id : " + portId);
    }

}
