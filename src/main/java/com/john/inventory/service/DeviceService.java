package com.john.inventory.service;

import com.john.inventory.model.Device;
import com.john.inventory.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service // esta clase es un componente de lógica de negocio
public class DeviceService {

    private final DeviceRepository repo; // se asigna una sola vez (en el constructor) y no cambia. Buena práctica.

    public DeviceService(DeviceRepository repo) { // Inyeccion por constructor,
        // desacopla, el service no sabe cómo se construye el repo
        // facilita testing, solo le pasas un mock en vez del repositorio real
        // Spring gestiona el ciclo de vida, una sola instancia y la reutiliza
        this.repo = repo;
    }

    public Device create(Device device) { // crea/guarda el nodo
        return repo.save(device);
    }

    public List<Device> getAll() {
        return repo.findAll();
    }

    public Device getById(String id) { // retorna Optional<Device>, evita NullPointerException
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No existe device con id" + id));
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public Device connectDevices(String fromId, String toId) {
        Device from = getById(fromId);
        Device to = getById(toId);
        from.connectTo(to);
        return repo.save(from);
    }
}
