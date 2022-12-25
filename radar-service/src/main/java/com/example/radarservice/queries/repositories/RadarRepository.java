package com.example.radarservice.queries.repositories;

import com.example.radarservice.queries.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
