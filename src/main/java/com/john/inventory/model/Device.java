package com.john.inventory.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.List;
import java.util.ArrayList;

@Node
public class Device {

    @Id @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String name;
    private String type;
    // ── La Relación ──
    @Relationship(type = "CONNECTED_TO", direction = Relationship.Direction.OUTGOING) // la flecha sale de este nodo hacia los otros
    private List<Device> connectedTo = new ArrayList<>();

    public Device() {}

    public Device(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Método para conectar dispositivos
    public void connectTo(Device other) {
        this.connectedTo.add(other);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public List<Device> getConnectedTo() { return connectedTo; }
    public void setConnectedTO(List<Device> connectedTo) { this.connectedTo = connectedTo; }
}
