package com.example.imatriculationservice.commands.controllers;

import com.example.openapi.commands.vehiculs.CreateVehiculeCommand;
import com.example.openapi.dtos.CreateVehicleDTO;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping("/commands")
public class VehicleCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    public VehicleCommandController(CommandGateway commandGateway , EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/vehicles/create")
    public CompletableFuture<String> createNewVehicle(@RequestBody CreateVehicleDTO request){
        return this.commandGateway.send(new CreateVehiculeCommand(
                UUID.randomUUID().toString(),
                request.getNumMatricule(),
                request.getMarque(),
                request.getModel(),
                request.getFiscalPower(),
                request.getOwnerName(),
                request.getOwnerAddress(),
                request.getOwnerPhone(),
                request.getOwnerEmail(),
                request.getOwnerNationalIdCard()

        ));
    }
    @GetMapping("/eventStore/{id}")
    public Stream eventStore (@PathVariable String id){
        return eventStore.readEvents(id).asStream();

    }
    }
