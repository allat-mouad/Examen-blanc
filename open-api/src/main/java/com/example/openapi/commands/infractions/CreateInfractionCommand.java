package com.example.openapi.commands.infractions;


import com.example.openapi.commands.BaseCommand;
import lombok.Getter;

import java.util.Date;

public class CreateInfractionCommand extends BaseCommand<String> {
    @Getter private String numMatricule;
    @Getter private double vehicleSpeed;
    @Getter private Date date;
    @Getter private String radarId;
    @Getter private double maxSpeedAllowed;

    public CreateInfractionCommand(String id, String numMatricule, double vehicleSpeed, Date date, String radarId, double maxSpeedAllowed) {
        super(id);
        this.numMatricule = numMatricule;
        this.vehicleSpeed = vehicleSpeed;
        this.date = date;
        this.radarId = radarId;
        this.maxSpeedAllowed = maxSpeedAllowed;
    }
}
