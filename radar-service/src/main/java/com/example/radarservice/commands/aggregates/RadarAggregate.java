package com.example.radarservice.commands.aggregates;

import com.example.openapi.commands.radar.CreateRadarCommand;
import com.example.openapi.events.RadarCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RadarAggregate {
    @AggregateIdentifier
    private String radarId;
    private int maxSpeed;
    private double longitude;
    private double latitude;

    public RadarAggregate() {}


    @CommandHandler
    public RadarAggregate(CreateRadarCommand command) {
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude()
        ));

    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event) {
        this.radarId = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();

    }

}
