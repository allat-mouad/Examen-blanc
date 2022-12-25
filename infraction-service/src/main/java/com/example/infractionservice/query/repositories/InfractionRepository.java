package com.example.infractionservice.query.repositories;

import com.example.infractionservice.query.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfractionRepository extends JpaRepository<Infraction,String> {
}
