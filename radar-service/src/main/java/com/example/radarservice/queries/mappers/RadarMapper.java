package com.example.radarservice.queries.mappers;

import com.example.radarservice.queries.entities.Radar;
import com.example.openapi.dtos.RadarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RadarMapper {
    RadarDTO radarToRadarDTO(Radar radar);
}
