package com.example.infractionservice.query.service;

import com.example.infractionservice.query.entities.Infraction;
import com.example.infractionservice.query.repositories.InfractionRepository;
import com.example.openapi.events.InfractionCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InfractionServiceHandler {
    private InfractionRepository infractionRepository;

    @EventHandler
    public void on(InfractionCreatedEvent event) {
        if(event.getMaxSpeedAllowed()< event.getVehicleSpeed()){
            Infraction infraction = new Infraction();
            infraction.setId(event.getId());
            infraction.setNumMatricule(event.getNumMatricule());
            infraction.setDate(event.getDate());
            infraction.setMaxSpeedAllowed(event.getMaxSpeedAllowed());
            infraction.setAmount(1000);
            infraction.setSpeed(event.getVehicleSpeed());

            infractionRepository.save(infraction);
        }
    }


}
