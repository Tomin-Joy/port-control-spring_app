package com.e.wtc.Service;

import java.util.List;

import com.e.wtc.entity.Ship;

public interface ShipService {

    public Ship createShip(Ship ship, int portId);

    public List<Ship> getAllShip();

    public Ship getShip(int shipId);

    public Ship updateShip(Ship ship, int ShipId);

    public String deleteShip(int shipId);
}
