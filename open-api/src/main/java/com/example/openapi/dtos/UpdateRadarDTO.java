package com.example.openapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateRadarDTO {
    private int maxSpeed;
    private double longitude;
    private double latitude;

}
