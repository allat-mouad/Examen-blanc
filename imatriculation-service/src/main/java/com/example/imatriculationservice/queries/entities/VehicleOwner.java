package com.example.imatriculationservice.queries.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class VehicleOwner {
    @Id
    private String id;
    private String ownerName;
    private String ownerAddress;
    private String ownerPhone;
    private String ownerEmail;
    private String ownerNationalIdCard;
    @OneToMany(mappedBy = "vehicleOwner")
    private List<Vehicle> vehicles;
}
