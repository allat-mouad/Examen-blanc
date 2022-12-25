package com.example.imatriculationservice.queries.repositories;

import com.example.imatriculationservice.queries.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
