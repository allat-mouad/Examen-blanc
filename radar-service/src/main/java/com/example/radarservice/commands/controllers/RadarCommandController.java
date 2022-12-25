package com.example.radarservice.commands.controllers;

import com.example.openapi.commands.radar.CreateRadarCommand;
import com.example.openapi.commands.radar.DeleteRadarCommand;
import com.example.openapi.commands.radar.UpdateRadarCommand;

import com.example.openapi.dtos.CreateRadarDTO;
import com.example.openapi.queries.radar.CreateRadar;
import com.example.openapi.queries.radar.DeleteRadar;
import com.example.openapi.queries.radar.UpdateRadar;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping("/commands")
public class RadarCommandController {
    private CommandGateway gateway;

    private EventStore eventStore;

    @PostMapping(path = "/radars/create")
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarDTO createRadarDTO) {
        return gateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                createRadarDTO.getMaxSpeed(),
                createRadarDTO.getLongitude(),
                createRadarDTO.getLatitude()
        ));
    }

    @PutMapping(path = "/radars/update")
    public CompletableFuture<String> updateRadar(@RequestBody UpdateRadar updateRadarDTO) {
        return gateway.send(new UpdateRadarCommand(
                updateRadarDTO.toString(),
                updateRadarDTO.getMaxSpeed(),
                updateRadarDTO.getLongitude(),
                updateRadarDTO.getLatitude()
        ));     }

    @DeleteMapping(path = "/radars/delete")
    public CompletableFuture<String> deleteRadar(@RequestBody DeleteRadar deleteRadar) {
        return gateway.send(new DeleteRadarCommand(deleteRadar.getId()));
    }
    @GetMapping("/eventStore/{id}")
    public Stream eventStore (@PathVariable String id){
        return eventStore.readEvents(id).asStream();

    }

}
