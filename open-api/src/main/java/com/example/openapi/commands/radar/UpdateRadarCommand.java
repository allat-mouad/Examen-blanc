package com.example.openapi.commands.radar;


import com.example.openapi.commands.BaseCommand;
import lombok.Getter;

public class UpdateRadarCommand extends BaseCommand<String> {
    @Getter
   private int maxSpeed;
    @Getter private double longitude;
    @Getter private double latitude;

    public UpdateRadarCommand(String id, int maxSpeed, double longitude, double latitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
