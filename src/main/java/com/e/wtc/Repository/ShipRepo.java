package com.e.wtc.Repository;

// import java.util.Optional;
// import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.e.wtc.entity.Ship;

public interface ShipRepo extends JpaRepository<Ship, Integer> {

    // @EntityGraph(attributePaths = "port")
    // Optional<Ship> findById(int shipId);
}
