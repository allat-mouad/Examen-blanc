package com.example.infractionservice.query.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Infraction {
    @Id
    private String id;
    private String numMatricule;
    private double Speed;
    private String radarId;
    private double amount;
    private Date date;
    private double maxSpeedAllowed;


}
