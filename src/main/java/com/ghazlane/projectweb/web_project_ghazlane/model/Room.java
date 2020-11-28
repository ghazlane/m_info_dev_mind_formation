package com.ghazlane.projectweb.web_project_ghazlane.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Double currentTemperature;

    @Column(nullable = true)
    private Double targetTemperature;

    @OneToMany(mappedBy = "room")
    private List<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private List<Window> windows;

    @ManyToOne
    private Building building;

    public Room() {
    }

    public Room(Long id, int floor, String name) {
        this.id = id;
        this.floor = floor;
        this.name = name;
    }

    public Room(Long id, int floor, String name, Double currentTemperature, Double targetTemperature, Building building) {
        this.id = id;
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    public List<com.ghazlane.projectweb.web_project_ghazlane.model.Window> getWindows() {
        return windows;
    }

    public void setWindows(List<com.ghazlane.projectweb.web_project_ghazlane.model.Window> windows) {
        this.windows = windows;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
