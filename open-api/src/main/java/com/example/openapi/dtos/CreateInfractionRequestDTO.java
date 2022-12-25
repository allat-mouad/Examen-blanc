package com.example.openapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInfractionRequestDTO {
    private String numMatricule;
    private double speed;
    private String radarId;
    private double radarSpeed;
    private Date date;
}
