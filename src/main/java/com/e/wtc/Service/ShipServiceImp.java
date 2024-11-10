package com.e.wtc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e.wtc.Exceptions.PortNotFoundException;
import com.e.wtc.Exceptions.ShipNotFoundException;
import com.e.wtc.Repository.PortRepo;
import com.e.wtc.Repository.ShipRepo;
import com.e.wtc.entity.Port;
import com.e.wtc.entity.Ship;

@Service
public class ShipServiceImp implements ShipService {

    @Autowired
    ShipRepo shipRepo;

    @Autowired
    PortRepo portRepo;

    @Override
    public String deleteShip(int shipId) {
        shipRepo.delete(shipRepo.findById(shipId).orElseThrow(() -> new ShipNotFoundException(shipId)));
        return "Deleted Succesfully";
    }

    @Override
    // @Transactional
    public List<Ship> getAllShip() {
        return shipRepo.findAll();
    }

    @Override
    public Ship updateShip(Ship ship, int ShipId) {
        Ship s = shipRepo.findById(ShipId).orElseThrow(() -> new ShipNotFoundException(ShipId));
        s.setShipName(ship.getShipName());
        s.setType(ship.getType());
        return shipRepo.save(s);
    }

    @Override
    public Ship createShip(Ship ship, int portId) {
        Port port = portRepo.findById(portId).orElseThrow(() -> new PortNotFoundException(portId));
        ship.setPort(port);
        return shipRepo.save(ship);
    }

    @Override
    @Transactional
    public Ship getShip(int shipId) {

        return shipRepo.findById(shipId).orElseThrow(() -> new ShipNotFoundException(shipId));
    }

}
