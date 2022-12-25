package com.example.imatriculationservice.queries.repositories;

import com.example.imatriculationservice.queries.entities.Vehicle;
import com.example.imatriculationservice.queries.entities.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<VehicleOwner, String> {

}
