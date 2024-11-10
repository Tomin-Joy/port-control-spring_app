package com.e.wtc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.wtc.Exceptions.DuplicatePortException;
import com.e.wtc.Exceptions.PortNotFoundException;
import com.e.wtc.Repository.PortRepo;
import com.e.wtc.entity.Port;

@Service
public class PortServiceImp implements PortService {

    @Autowired
    PortRepo repo;

    @Override
    public Port createPort(Port port) {
        if (repo.existsByPortName(port.getPortName())) {
            throw new DuplicatePortException(port.getPortName());
        }
        return repo.save(port);
    }

    @Override
    public Port getport(int portId) {
        return repo.findById(portId).orElseThrow(() -> new PortNotFoundException(portId));
    }

}
