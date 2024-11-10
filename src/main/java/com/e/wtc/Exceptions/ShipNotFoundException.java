package com.e.wtc.Exceptions;

public class ShipNotFoundException extends RuntimeException {

    public ShipNotFoundException(int shipId) {
        super("Ship not found with Id : " + shipId);
    }
}
