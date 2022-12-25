package com.example.imatriculationservice.queries.services;

import com.example.imatriculationservice.queries.entities.Vehicle;
import com.example.imatriculationservice.queries.repositories.VehicleRepository;
import com.example.openapi.dtos.RadarDTO;
import com.example.openapi.events.RadarCreatedEvent;
import com.example.openapi.events.VehiculeCreatedEvent;
import com.example.openapi.queries.radar.GetAllRadars;
import com.example.openapi.queries.radar.GetRadar;
import com.example.openapi.queries.vehiculs.GetAllVehicules;
import com.example.openapi.queries.vehiculs.GetVehicle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class VehicleQueryService
{
    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleQueryService(VehicleRepository vehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
    }
    @EventSourcingHandler
    public void on(VehiculeCreatedEvent event) {
        Vehicle vehicle = Vehicle.builder()
                .id(event.getId())
                .marque(event.getMarque())
                .model(event.getModel())
                .fiscalPower(event.getFiscalPower())
                .build();
        vehicleRepository.save(vehicle);
    }

    @QueryHandler
    public Vehicle getVehicule(GetVehicle request) {
        return vehicleRepository.findById(request.getId()).get();

    }

    @QueryHandler
    public List<Vehicle> getVehiculs(GetAllVehicules request) {
        return vehicleRepository.findAll();
    }



}
