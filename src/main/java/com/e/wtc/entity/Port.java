package com.e.wtc.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String portName;
    private String location;
    @OneToMany(mappedBy = "port", cascade = CascadeType.ALL)
    // @JsonManagedReference
    @JsonIgnoreProperties("port")
    private List<Ship> ships;

    public Port() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void addShip(Ship ship) {
        this.ships.add(ship);
    }

}
