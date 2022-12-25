package com.example.infractionservice.commands.aggregates;

import com.example.openapi.commands.infractions.CreateInfractionCommand;
import com.example.openapi.events.InfractionCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class InfractionAggregate {
    @AggregateIdentifier
    private String id;
    private String numMatricule;
    private double vehicleSpeed;
    private Date date;
    private String radarId;
    private double maxSpeedAllowed;

    public InfractionAggregate() {
    }

    @CommandHandler
    public InfractionAggregate(CreateInfractionCommand command) {
        if (command.getNumMatricule() == null || command.getNumMatricule().isEmpty()) {
            throw new IllegalArgumentException("Matricule cannot be empty");
        }
        AggregateLifecycle.apply(new InfractionCreatedEvent(
                command.getId(),
                command.getNumMatricule(),
                command.getVehicleSpeed(),
                command.getDate(),
                command.getRadarId(),
                command.getMaxSpeedAllowed()));
    }
    @EventSourcingHandler
    public void on(InfractionCreatedEvent event) {
        this.id = event.getId();
        this.numMatricule = event.getNumMatricule();
        this.vehicleSpeed = event.getVehicleSpeed();
        this.date = event.getDate();
        this.radarId = event.getRadarId();
        this.maxSpeedAllowed = event.getMaxSpeedAllowed();
    }
}
