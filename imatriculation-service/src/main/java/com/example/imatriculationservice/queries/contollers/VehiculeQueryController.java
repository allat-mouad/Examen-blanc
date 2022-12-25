package com.example.imatriculationservice.queries.contollers;

import com.example.imatriculationservice.queries.entities.Vehicle;
import com.example.openapi.queries.vehiculs.GetAllVehicules;
import com.example.openapi.queries.vehiculs.GetVehicle;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/query/vehicules")
public class VehiculeQueryController {
    private QueryGateway queryGateway;


    @GetMapping
    public CompletableFuture<List<Vehicle>> getVehicules() {
        return queryGateway.query(new GetAllVehicules(), ResponseTypes.multipleInstancesOf(Vehicle.class));
    }

    @GetMapping(path = "/{id}")
    public CompletableFuture<Vehicle> getVehicule(@PathVariable String id) {
        return queryGateway.query(new GetVehicle(id), Vehicle.class);
    }


}
