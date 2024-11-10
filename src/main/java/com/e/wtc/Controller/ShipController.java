package com.e.wtc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.e.wtc.Exceptions.PortNotFoundException;
import com.e.wtc.Exceptions.ShipNotFoundException;
import com.e.wtc.Service.ShipServiceImp;
import com.e.wtc.entity.Ship;

@RestController
@RequestMapping(value = "ship")
public class ShipController {

    @Autowired
    ShipServiceImp service;

    @PostMapping(value = "port/{portId}")
    public ResponseEntity<Ship> createShip(@RequestBody Ship ship, @PathVariable int portId) {
        Ship s = service.createShip(ship, portId);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @GetMapping("{shipId}")
    public ResponseEntity<Ship> getShip(@PathVariable int shipId) {
        Ship s = service.getShip(shipId);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ship>> getShips() {
        List<Ship> allShip = service.getAllShip();
        return new ResponseEntity<>(allShip, HttpStatus.OK);
    }

    @PutMapping("{shipId}")
    public ResponseEntity<Ship> updateShip(@RequestBody Ship ship, @PathVariable int shipId) {
        Ship updateShip = service.updateShip(ship, shipId);
        return new ResponseEntity<>(updateShip, HttpStatus.OK);
    }

    @DeleteMapping("{shipId}")
    public ResponseEntity<String> deleteShip(@PathVariable int shipId) {
        String deleteShip = service.deleteShip(shipId);
        return new ResponseEntity<>(deleteShip, HttpStatus.OK);
    }

    @ExceptionHandler(PortNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePortnotException(PortNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ShipNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleShipnotException(ShipNotFoundException ex) {
        return ex.getMessage();
    }
}
