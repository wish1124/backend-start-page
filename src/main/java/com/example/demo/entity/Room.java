package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int capacity;
    private boolean hasProjector;
    private boolean hasWhiteboard;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getCapacity() { return capacity; }
    public boolean isHasProjector() { return hasProjector; }
    public boolean isHasWhiteboard() { return hasWhiteboard; }
}
