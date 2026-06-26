package com.john.inventory.repository;

import com.john.inventory.model.Device;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.List;

public interface DeviceRepository extends Neo4jRepository<Device, String>{
    // save, findById, findAll, deleteById
    List<Device> findByType(String type);
}

// El repository es una interfaz que extiende Neo4jRepository;
// Spring Data genera la implementación CRUD en runtime y traduce las operaciones a Cypher.
// Para consultas específicas, basta declarar métodos con nombres convencionales —queries derivadas—
// y Spring las implementa solo."