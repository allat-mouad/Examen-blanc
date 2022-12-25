package com.example.openapi.queries.vehiculs;


import com.example.openapi.queries.BaseQuery;

public class GetVehicle extends BaseQuery<String> {
    public GetVehicle(String id) {
        super(id);
    }
}
