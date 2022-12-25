package com.example.infractionservice.commands.controllers;

import com.example.openapi.commands.infractions.CreateInfractionCommand;
import com.example.openapi.dtos.CreateInfractionRequestDTO;
import lombok.AllArgsConstructor;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands")
@AllArgsConstructor
@Service
public class InfractionCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/infraction/create")
    public CompletableFuture<String> create(@RequestBody CreateInfractionRequestDTO createInfractionRequestDTO){
        CompletableFuture<String> response = commandGateway.send(new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                createInfractionRequestDTO.getNumMatricule(),
                createInfractionRequestDTO.getSpeed(),
                createInfractionRequestDTO.getDate(),
                createInfractionRequestDTO.getRadarId(),
                createInfractionRequestDTO.getRadarSpeed()
        ));
        return response;
    }
}
