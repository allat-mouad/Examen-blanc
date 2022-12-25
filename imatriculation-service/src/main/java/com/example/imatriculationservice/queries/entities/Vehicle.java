package com.example.imatriculationservice.queries.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    private String id;
    private String marque;
    private String model;
    private  int  fiscalPower;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private VehicleOwner vehicleOwner;
}
