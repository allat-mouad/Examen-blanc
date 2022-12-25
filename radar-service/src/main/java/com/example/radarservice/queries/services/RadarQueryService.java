package com.example.radarservice.queries.services;


import com.example.openapi.dtos.RadarDTO;
import com.example.openapi.events.RadarCreatedEvent;
import com.example.openapi.queries.radar.GetAllRadars;
import com.example.openapi.queries.radar.GetRadar;
import com.example.radarservice.queries.entities.Radar;
import com.example.radarservice.queries.mappers.RadarMapper;
import com.example.radarservice.queries.repositories.RadarRepository;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RadarQueryService {

    @Autowired
    private RadarRepository radarRepository;
    @Autowired
    private RadarMapper radarMapper;

    @EventSourcingHandler
    public void on(RadarCreatedEvent event) {
        Radar radar = Radar.builder()
                .id(event.getId())
                .maxSpeed(event.getMaxSpeed())
                .longitude(event.getLongitude())
                .latitude(event.getLatitude())
                .build();
        radarRepository.save(radar);
    }

    @QueryHandler
    public RadarDTO getRadarById(GetRadar request) {
        Radar radar = radarRepository.findById(request.getId()).get();
        return radarMapper.radarToRadarDTO(radar);
    }

    @QueryHandler
    public List<RadarDTO> getRadarList(GetAllRadars request) {
        List<Radar> list = radarRepository.findAll();
        return list.stream().map(radar -> radarMapper.radarToRadarDTO(radar)).collect(Collectors.toList());
    }
}
