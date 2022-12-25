package com.example.openapi.events;

import lombok.Getter;

import java.util.Date;

public class InfractionCreatedEvent extends BaseEvent<String> {

    @Getter private String numMatricule;
    @Getter private double vehicleSpeed;
    @Getter private Date date;
    @Getter private String radarId;
    @Getter private double maxSpeedAllowed;

    public InfractionCreatedEvent(String id, String matricule, double vehicleSpeed, Date date, String radarId, double maxSpeedAllowed) {
        super(id);
        this.numMatricule = matricule;
        this.vehicleSpeed = vehicleSpeed;
        this.date = date;
        this.radarId = radarId;
        this.maxSpeedAllowed = maxSpeedAllowed;
    }
}
