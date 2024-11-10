package com.e.wtc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.e.wtc.Exceptions.DuplicatePortException;
import com.e.wtc.Exceptions.PortNotFoundException;
import com.e.wtc.Service.PortServiceImp;
import com.e.wtc.entity.Port;

@RestController
@RequestMapping(value = "port")
public class PortController {

    @Autowired
    PortServiceImp service;

    @PostMapping
    public ResponseEntity<Port> createPort(@RequestBody Port port) {
        Port p = service.createPort(port);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("{portId}")
    public ResponseEntity<Port> getPort(@PathVariable int portId) {
        Port p = service.getport(portId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @ExceptionHandler(PortNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePortnotException(PortNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(DuplicatePortException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleDuplicatePortException(DuplicatePortException ex) {
        return ex.getMessage();
    }

}
