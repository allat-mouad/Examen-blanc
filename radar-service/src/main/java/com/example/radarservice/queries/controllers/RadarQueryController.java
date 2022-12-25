package com.example.radarservice.queries.controllers;


import com.example.openapi.dtos.RadarDTO;
import com.example.openapi.queries.radar.GetAllRadars;
import com.example.openapi.queries.radar.GetRadar;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/query/radars")
public class RadarQueryController {

    private QueryGateway gateway;

    @GetMapping
    public CompletableFuture<List<RadarDTO>> getRadarList() {
        return gateway.query(new GetAllRadars(), ResponseTypes.multipleInstancesOf(RadarDTO.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<RadarDTO> getRadarById(@PathVariable String id) {
        return gateway.query(new GetRadar(id), ResponseTypes.instanceOf(RadarDTO.class));
    }


}
