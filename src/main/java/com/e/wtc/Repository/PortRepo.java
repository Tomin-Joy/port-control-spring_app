package com.e.wtc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e.wtc.entity.Port;

public interface PortRepo extends JpaRepository<Port, Integer> {

    public boolean existsByPortName(String portName);

}
