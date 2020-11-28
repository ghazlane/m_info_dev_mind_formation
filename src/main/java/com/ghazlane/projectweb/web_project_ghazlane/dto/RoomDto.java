package com.ghazlane.projectweb.web_project_ghazlane.dto;

import com.ghazlane.projectweb.web_project_ghazlane.model.Room;


public class RoomDto {

    private Long id;
    private int floor;
    private String name;
    private Double currentTemperature;
    private Double targetTemperature;
    private Long buildingId;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.floor = room.getFloor();
        this.name = room.getName();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.buildingId = room.getBuilding().getId();
    }

    public RoomDto(int floor, String name, Double currentTemperature, Double targetTemperature, Long buildingId) {
        this.name = name;
        this.floor = floor;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.buildingId = buildingId;
    }

    public RoomDto(Long id, int floor, String name, Double currentTemperature, Double targetTemperature, Long buildingId) {
        this.id = id;
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.buildingId = buildingId;
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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }
}
