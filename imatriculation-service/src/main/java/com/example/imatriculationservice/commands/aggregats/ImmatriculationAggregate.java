package com.example.imatriculationservice.commands.aggregats;

import com.example.openapi.commands.vehiculs.CreateVehiculeCommand;
import com.example.openapi.events.VehiculeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate

public class ImmatriculationAggregate {
    @AggregateIdentifier
    private String id;
    private String marque;
    private String model;
    private int fiscalPower;
    private String ownerName;
    private String ownerNationalIdCard;
    private String ownerEmail;
    private String ownerPhoneNumber;
    private String ownerAddress;

    public ImmatriculationAggregate() {
    }
    @CommandHandler
    public ImmatriculationAggregate(CreateVehiculeCommand command) {
        AggregateLifecycle.apply(new VehiculeCreatedEvent(
                command.getId(),
                command.getNumMatricule(),
                command.getMarque(),
                command.getModel(),
                command.getFiscalPower(),
                command.getOwnerName(),
                command.getOwnerAddress(),
                command.getOwnerPhone(),
                command.getOwnerEmail(),
                command.getOwnerNationalIdCard()
        ));
    }
    @EventSourcingHandler
    public void on(VehiculeCreatedEvent event) {
        this.id=event.getId();
        this.marque=event.getMarque();
        this.model=event.getModel();
        this.fiscalPower=event.getFiscalPower();
        this.ownerName=event.getOwnerName();
        this.ownerAddress=event.getOwnerAddress();
        this.ownerPhoneNumber=event.getOwnerPhone();
        this.ownerEmail=event.getOwnerEmail();
        this.ownerNationalIdCard=event.getOwnerNationalIdCard();

    }



}
