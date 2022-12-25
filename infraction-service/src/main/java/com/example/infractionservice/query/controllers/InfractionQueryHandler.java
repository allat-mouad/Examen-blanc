package com.example.infractionservice.query.controllers;

import com.example.infractionservice.query.entities.Infraction;
import com.example.openapi.queries.infractions.GetAllInfractions;
import com.example.openapi.queries.infractions.GetInfraction;
import lombok.AllArgsConstructor;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/query/infractions")
@Service
public class InfractionQueryHandler {
    private QueryGateway queryGateway;

    public InfractionQueryHandler(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public CompletableFuture<List<Infraction>> getInfractions(){
        return queryGateway.query(new GetAllInfractions(), ResponseTypes.multipleInstancesOf(Infraction.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Infraction> getInfraction(@PathVariable String id){
        return queryGateway.query(new GetInfraction(id), ResponseTypes.instanceOf(Infraction.class));
    }


}
