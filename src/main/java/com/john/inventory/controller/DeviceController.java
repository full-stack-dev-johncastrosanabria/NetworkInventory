package com.john.inventory.controller;

import com.john.inventory.model.Device;
import com.john.inventory.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService service; // depende del service

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    // POST /api/devices  → crea un device
    @PostMapping
    public Device create(@RequestBody Device device) {
        return service.create(device);
    }

    // GET /api/devices  → trae todos
    @GetMapping
    public List<Device> getAll() {
        return service.getAll();
    }

    // GET /api/devices/{id}  → trae uno por id
    @GetMapping("/{id}")
    public Device getById(@PathVariable String id) {
        return service.getById(id);
    }

    // DELETE /api/devices/{id}  → borra uno
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    // POST /api/devices/{uuid1}/connect/{uuid2}
    @PostMapping("/{fromId}/connect/{toId}")
    public Device connect(@PathVariable String fromId, @PathVariable String toId) {
        return service.connectDevices(fromId, toId);
    }
}

// @RestController — combina dos cosas: "esta clase maneja peticiones web" + "lo que devuelvan los métodos conviértelo a JSON automáticamente". Por eso cuando devuelves un Device, el cliente recibe {"id":..., "name":..., "type":...} sin que tú serialices nada.
// @RequestMapping("/api/devices") — prefijo común. Todos los endpoints de esta clase empiezan con /api/devices. Así no repites la ruta en cada método.
// @PostMapping / @GetMapping / @DeleteMapping — el verbo HTTP. POST = crear, GET = leer, DELETE = borrar. Es la convención REST: la misma ruta (/api/devices/5) hace cosas distintas según el verbo.
// @RequestBody — toma el JSON que viene en el cuerpo de la petición y lo convierte en un objeto Device. Es lo inverso de la serialización: el cliente manda {"name":"Router-1","type":"DWDM"} y Spring te lo entrega como un Device listo.
// @PathVariable — extrae un valor de la URL. En GET /api/devices/5, el 5 se captura en el parámetro id gracias a que la ruta es /{id} y el parámetro lleva @PathVariable.