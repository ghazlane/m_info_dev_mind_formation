package com.ghazlane.projectweb.web_project_ghazlane.dto;

import com.ghazlane.projectweb.web_project_ghazlane.model.Heater;
import com.ghazlane.projectweb.web_project_ghazlane.model.HeaterStatus;

public class HeaterDto {

    private Long id;
    private String name;
    private Long power;
    private Long roomId;
    private HeaterStatus heaterStatus;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.power = heater.getPower();
        this.roomId = heater.getRoom().getId();
        this.heaterStatus = heater.getHeaterStatus();
    }

    public HeaterDto(Long id, String name, Long power, Long roomId, HeaterStatus heaterStatus) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.roomId = roomId;
        this.heaterStatus = heaterStatus;
    }

    public HeaterDto(String name, Long power, Long roomId, HeaterStatus heaterStatus) {
        this.name = name;
        this.power = power;
        this.roomId = roomId;
        this.heaterStatus = heaterStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
